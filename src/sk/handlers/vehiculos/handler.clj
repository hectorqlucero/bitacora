(ns sk.handlers.vehiculos.handler
  (:require [sk.models.crud :refer [build-form-row
                                    build-form-save
                                    build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.models.util :refer [get-session-id
                                    user-level]]
            [sk.layout :refer [application]]
            [sk.handlers.vehiculos.view :refer [vehiculos-view
                                               vehiculos-scripts]]))

(defn vehiculos
  [_]
  (try
    (let [title "Vehiculos"
          ok (get-session-id)
          js (vehiculos-scripts)
          content (vehiculos-view title)]
      (application title ok js content))
    (catch Exception e (.getMessage e))))

(defn vehiculos-grid
  [{params :params}]
  (try
    (let [table "vehiculos"
          args {:sort-extra "sucursal,vehiculo"}]
      (build-grid params table args))
    (catch Exception e (.getMessage e))))

(defn vehiculos-form
  [id]
  (try
    (let [table "vehiculos"]
      (build-form-row table id))
    (catch Exception e (.getMessage e))))

(defn vehiculos-save
  [{params :params}]
  (try
    (let [table "vehiculos"]
      (build-form-save params table))
    (catch Exception e (.getMessage e))))

(defn vehiculos-delete
  [{params :params}]
  (try
    (let [table "vehiculos"]
      (build-form-delete params table))
    (catch Exception e (.getMessage e))))
