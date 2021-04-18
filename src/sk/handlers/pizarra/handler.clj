(ns sk.handlers.pizarra.handler
  (:require [sk.models.crud :refer [Query db]]
            [sk.models.util :refer [get-session-id
                                    user-level]]
            [sk.handlers.pizarra.sql :refer :all]
            [sk.layout :refer [application]]
            [sk.handlers.pizarra.view :refer [pizarra-view
                                              pizarra-process-view
                                              pizarra-scripts]]))

(defn pizarra
  [_]
  (try
    (let [title "Pizarra"
          ok (get-session-id)
          js (pizarra-scripts)
          content (pizarra-view title)]
      (application title ok js content))
    (catch Exception e (.getMessage e))))

(defn pizarra-process
  [sucursal_id]
  (try
    (let [title "Pizarra"
          vrows (Query db [vehiculos-sql sucursal_id])
          brows (Query db [bitacora-sql sucursal_id])
          irows (Query db [inv_vehiculos-sql sucursal_id])
          ok (get-session-id)
          js (pizarra-scripts)
          content (pizarra-process-view title vrows brows irows)]
      (application title ok js content))
    (catch Exception e (.getMessage e))))
