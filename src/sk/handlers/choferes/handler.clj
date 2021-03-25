(ns sk.handlers.choferes.handler
  (:require [sk.models.crud :refer [build-form-row
                                    build-form-save
                                    build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.models.util :refer [get-session-id
                                    user-level]]
            [sk.layout :refer [application]]
            [sk.handlers.choferes.view :refer [choferes-view
                                               choferes-scripts]]))

(defn choferes
  [_]
  (try
    (let [title "Choferes"
          ok (get-session-id)
          js (choferes-scripts)
          content (choferes-view title)]
      (application title ok js content))
    (catch Exception e (.getMessage e))))

(defn choferes-grid
  [{params :params}]
  (try
    (let [table "choferes"
          args {:sort-extra "chofer"}]
      (build-grid params table args))
    (catch Exception e (.getMessage e))))

(defn choferes-form
  [id]
  (try
    (let [table "choferes"]
      (build-form-row table id))
    (catch Exception e (.getMessage e))))

(defn choferes-save
  [{params :params}]
  (try
    (let [table "choferes"]
      (build-form-save params table))
    (catch Exception e (.getMessage e))))

(defn choferes-delete
  [{params :params}]
  (try
    (let [table "choferes"]
      (build-form-delete params table))
    (catch Exception e (.getMessage e))))
