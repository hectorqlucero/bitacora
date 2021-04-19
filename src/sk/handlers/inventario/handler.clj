(ns sk.handlers.inventario.handler
  (:require [sk.models.crud :refer [build-form-row
                                    build-grid-columns
                                    build-form-save
                                    build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.models.util :refer [get-session-id
                                    user-level]]
            [sk.layout :refer [application]]
            [sk.handlers.inventario.view :refer [inventario-view
                                               inventario-scripts]]))
(defn inventario
  [_]
  (try
    (let [title "Inventario de Vehiculos"
          ok (get-session-id)
          js (inventario-scripts)
          content (inventario-view title)]
      (application title ok js content))
    (catch Exception e (.getMessage e))))

;; Start inventario grid
(def grid-aliases
  (conj (build-grid-columns "inv_vehiculos")
        (str " vehiculos.vehiculo as vehiculo_id_formatted,"
             " choferes.chofer as chofer_id_formatted,"
             " vehiculos.num_serie as num_serie,"
             " sucursales.sucursal as sucursal_id_formatted")))

(def grid-join
  (str " JOIN vehiculos on vehiculos.id = inv_vehiculos.vehiculo_id"
       " JOIN choferes on choferes.id = inv_vehiculos.chofer_id"
       " JOIN sucursales on sucursales.id = inv_vehiculos.sucursal_id"))

(defn inventario-grid
  [{params :params}]
  (try
    (let [table "inv_vehiculos"
          args {:sort-extra "inv_vehiculos.fecha desc"
                :aliases grid-aliases
                :join grid-join}]
      (build-grid params table args))
    (catch Exception e (.getMessage e))))
;; End inventario grid

(defn inventario-form
  [id]
  (try
    (let [table "inv_vehiculos"]
      (build-form-row table id))
    (catch Exception e (.getMessage e))))

(defn inventario-save
  [{params :params}]
  (try
    (let [table "inv_vehiculos"]
      (build-form-save params table))
    (catch Exception e (.getMessage e))))

(defn inventario-delete
  [{params :params}]
  (try
    (let [table "inv_vehiculos"]
      (build-form-delete params table))
    (catch Exception e (.getMessage e))))
