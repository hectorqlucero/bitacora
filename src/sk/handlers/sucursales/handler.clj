(ns sk.handlers.sucursales.handler
  (:require [sk.models.crud :refer [build-form-row
                                    build-form-save
                                    build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.models.util :refer [get-session-id
                                    user-level]]
            [sk.layout :refer [application]]
            [sk.handlers.sucursales.view :refer [sucursales-view
                                               sucursales-scripts]]))

(defn sucursales
  [_]
  (try
    (let [title "Sucursales"
          ok (get-session-id)
          js (sucursales-scripts)
          content (sucursales-view title)]
      (application title ok js content))
    (catch Exception e (.getMessage e))))

(defn sucursales-grid
  [{params :params}]
  (try
    (let [table "sucursales"
          args {:sort-extra "sucursal"}]
      (build-grid params table args))
    (catch Exception e (.getMessage e))))

(defn sucursales-form
  [id]
  (try
    (let [table "sucursales"]
      (build-form-row table id))
    (catch Exception e (.getMessage e))))

(defn sucursales-save
  [{params :params}]
  (try
    (let [table "sucursales"]
      (build-form-save params table))
    (catch Exception e (.getMessage e))))

(defn sucursales-delete
  [{params :params}]
  (try
    (let [table "sucursales"]
      (build-form-delete params table))
    (catch Exception e (.getMessage e))))
