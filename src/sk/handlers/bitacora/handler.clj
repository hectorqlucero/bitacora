(ns sk.handlers.bitacora.handler
  (:require [sk.models.crud :refer [build-form-row
                                    build-form-save
                                    build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.models.util :refer [get-session-id
                                    user-level]]
            [sk.layout :refer [application]]
            [sk.handlers.bitacora.view :refer [bitacora-view
                                               bitacora-scripts]]))

(defn bitacora
  [_]
  (try
    (let [title "Bitacora"
          ok (get-session-id)
          js (bitacora-scripts)
          content (bitacora-view title)]
      (application title ok js content))
    (catch Exception e (.getMessage e))))

;; Start bitacora grid
(def bitacora-aliases
  [
   "bitacora.id as id"
   "sucursales.sucursal as sucursal"
   "vehiculos.vehiculo as vehiculo_id"
   "vehiculos.num_serie as num_serie"
   "bitacora.fecha_reparacion as fecha_reparacion"
   "DATE_FORMAT(bitacora.fecha_reparacion,'%m/%d/%Y') as fecha_reparacion_formatted"
   "bitacora.desc_reparacion as desc_reparacion"
   "bitacora.observaciones as observaciones"])

(def bitacora-join
  "LEFT JOIN vehiculos on vehiculos.id = bitacora.vehiculo_id
  LEFT JOIN sucursales on sucursales.id = bitacora.sucursal_id")

(defn bitacora-grid
  [{params :params}]
  (try
    (let [table "bitacora"
          args {:aliases bitacora-aliases
                :join bitacora-join
                :sort-extra "fecha_reparacion desc"}]
      (build-grid params table args))
    (catch Exception e (.getMessage e))))
;; End bitacora grid

(defn bitacora-form
  [id]
  (try
    (let [table "bitacora"]
      (build-form-row table id))
    (catch Exception e (.getMessage e))))

(defn bitacora-save
  [{params :params}]
  (try
    (let [table "bitacora"]
      (build-form-save params table))
    (catch Exception e (.getMessage e))))

(defn bitacora-delete
  [{params :params}]
  (try
    (let [table "bitacora"]
      (build-form-delete params table))
    (catch Exception e (.getMessage e))))
