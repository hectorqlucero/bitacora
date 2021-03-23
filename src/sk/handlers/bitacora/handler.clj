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

(defn bitacora-grid
  [{params :params}]
  (try
    (let [table "bitacora"
          args nil]
      (build-grid params table args))
    (catch Exception e (.getMessage e))))

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
