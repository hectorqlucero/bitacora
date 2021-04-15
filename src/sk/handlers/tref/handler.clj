(ns sk.handlers.tref.handler
  (:require [sk.models.crud :refer [db Query]]
            [sk.models.util :refer [parse-int
                                    get-image
                                    current_year]]))

;; Start get-users
(def get-users-sql
  "SELECT
  id AS value,
  CONCAT(firstname,' ',lastname) AS text
  FROM users
  ORDER BY
  firstname,lastname")

(defn get-users
  "Gets all users from database :ex: (get-users)"
  []
  (Query db [get-users-sql]))
;; End get-users

;; Start vehiculo_exists
(defn get-vehiculo_exists
  "Checa si el vehiculo existe en la table inv_vehiculos"
  [id]
  (let [row (first (Query db ["SELECT vehiculo_id FROM inv_vehiculos WHERE vehiculo_id = ?" id]))
        item (:vehiculo_id row)
        result (if (nil? item) "ok" "error")]
    result))
;; End vehiculo_exists

;; Start get-vehiculos
(def get-vehiculos-sql
  "SELECT
  id AS value,
  CONCAT('Vehiculo: ',vehiculo,' Modelo: ',modelo,' Serie: ',num_serie) as text
  FROM vehiculos
  ORDER BY modelo")

(defn get-vehiculos
  "Regrasa todos los vehiculos"
  []
  (let [vrows (Query db [get-vehiculos-sql])])
  (Query db [get-vehiculos-sql]))
;; End get-vehiculos

;; Start get-unique-vehiculos
(defn get-unique-vehiculos-sql
  [filtro]
  (str
    "SELECT
    id AS value,
    CONCAT('Vehiculo: ',vehiculo,' Modelo: ',modelo,' Serie: ',num_serie) as text
    FROM vehiculos
    WHERE id IN(" filtro ")"))

(defn get-unique-vehiculos
  "Regresa solo los vehiculos unicos - se usa para la table de inv_vehiculos"
  []
  (let [vrows (Query db "SELECT id FROM vehiculos")
        irows (Query db ["SELECT vehiculo_id FROM inv_vehiculos"])
        vlist (set (flatten (map #(vals %) vrows)))
        ilist (set (flatten (map #(vals %) irows)))
        items (apply str (apply list (clojure.set/difference vlist ilist)))
        filtro (apply str (interpose "," items))
        rows (Query db (get-unique-vehiculos-sql filtro))]
    rows))
;; End get-unique-vehiculos

;; Start get-users-email
(def get-users-email-sql
  "SELECT
  LOWER(email) as email
  FROM users
  WHERE email = ?")

(defn get-users-email
  "Returns user email or nil"
  [email]
  (first (Query db [get-users-email-sql email])))
;; End get-users-email

;; Start get-nserie
(def get-nseries-sql
  "SELECT
  num_serie AS value,
  num_serie as text
  FROM vehiculos
  ORDER BY num_serie")

(defn get-nseries
  "Regresa todos los numeros de serie de los vehiculos"
  []
  (Query db [get-nseries-sql]))
;; End get-nserie

;; Start get-nserie
(def get-nserie-sql
  "SELECT
  num_serie AS value,
  num_serie AS text
  FROM vehiculos
  WHERE id = ?")

(defn get-nserie
  "Regresa un numero de serie - se pasa el vehiculo id"
  [vehiculo_id]
  (Query db [get-nserie-sql vehiculo_id]))
;; End get-nserie

;; Start get-serie
(def get-v_serie-sql
  "SELECT
  CONCAT(num_serie,' -  ',vehiculo) as num_serie
  FROM vehiculos
  WHERE id = ?")

(defn get-v_serie
  "Regresa la serie concatenada al vehiculo"
  [vehiculo-id]
  (:num_serie (first (Query db [get-v_serie-sql vehiculo-id]))))
;; End get-serie

;; Start get-sucursales
(def get-sucursales-sql
  "SELECT
  id AS value,
  sucursal AS text
  FROM sucursales
  ORDER BY sucursal")

(defn get-sucursales
  "Regresa todas las sucursales"
  []
  (Query db [get-sucursales-sql]))
;; End get-sucursales

(defn get-sucursal
  "Regresa una sucursal dependiendo de la llave"
  [id]
  (:sucursal (first (Query db ["SELECT sucursal FROM sucursales where id = ?" id]))))

;; Start get-choferes
(def get-choferes-sql
  "SELECT
  id AS value,
  chofer AS text
  FROM choferes
  ORDER BY chofer")

(defn get-choferes
  "Regresa todos los choferes"
  []
  (Query db [get-choferes-sql]))
;; End get-choferes

;; Start get-v_chofer
(def get-v_chofer-sql
  "SELECT
  c.chofer
  FROM vehiculos v
  LEFT JOIN choferes c on c.id = v.chofer_asignado
  WHERE v.id = ?")

(defn get-v_chofer
  "Regresa un chofer dependiendo de la llave del vehiculo"
  [vehiculo-id]
  (:chofer (first (Query db [get-v_chofer-sql vehiculo-id]))))
;; End get-chofer

(defn months
  "Returns months name ex: (months)"
  []
  (list
   {:value 1 :text "January"}
   {:value 2 :text "February"}
   {:value 3 :text "March"}
   {:value 4 :text "April"}
   {:value 5 :text "May"}
   {:value 6 :text "June"}
   {:value 7 :text "July"}
   {:value 8 :text "August"}
   {:value 9 :text "September"}
   {:value 10 :text "October"}
   {:value 11 :text "November"}
   {:value 12 :text "Dicember"}))

(defn level-options []
  (list
    {:value "U" :text "Users"}
    {:value "A" :text "Administrator"}
    {:value "S" :text "System"}))

(defn years
  "Genera listado para dropdown dependiendo de p=anterioriores de este año, n=despues de este año,
  ex: (years 5 4)"
  [p n]
  (let [year   (parse-int (current_year))
        pyears (for [n (range (parse-int p) 0 -1)] {:value (- year n) :text (- year n)})
        nyears (for [n (range 0 (+ (parse-int n) 1))] {:value (+ year n) :text (+ year n)})
        years  (concat pyears nyears)]
    years))

(defn imagen [table field idname value & extra-folder]
  (get-image table field idname value (first extra-folder)))

(defn get-item 
  "Generic get field value from table"
  [table field idname idvalue]
  (let [sql (str "SELECT " field " FROM " table " WHERE " idname "='" idvalue "'")
        row (first (Query db sql))]
    ((keyword field) row)))
