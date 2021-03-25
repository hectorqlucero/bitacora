(ns sk.handlers.estado.handler
  (:require [sk.models.crud :refer [build-form-row
                                    build-form-save
                                    build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.models.util :refer [get-session-id
                                    user-level]]
            [sk.layout :refer [application]]
            [sk.handlers.estado.view :refer [estado-view
                                               estado-scripts]]))

(defn estado
  [_]
  (try
    (let [title "Estados"
          ok (get-session-id)
          js (estado-scripts)
          content (estado-view title)]
      (application title ok js content))
    (catch Exception e (.getMessage e))))

(defn estado-grid
  [{params :params}]
  (try
    (let [table "estado"
          args {:sort-extra "estado"}]
      (build-grid params table args))
    (catch Exception e (.getMessage e))))

(defn estado-form
  [id]
  (try
    (let [table "estado"]
      (build-form-row table id))
    (catch Exception e (.getMessage e))))

(defn estado-save
  [{params :params}]
  (try
    (let [table "estado"]
      (build-form-save params table))
    (catch Exception e (.getMessage e))))

(defn estado-delete
  [{params :params}]
  (try
    (let [table "estado"]
      (build-form-delete params table))
    (catch Exception e (.getMessage e))))
