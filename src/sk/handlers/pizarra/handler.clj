(ns sk.handlers.pizarra.handler
  (:require [sk.models.crud :refer [Query db]]
            [sk.models.util :refer [get-session-id
                                    user-level]]
            [sk.layout :refer [application]]
            [sk.handlers.pizarra.view :refer [pizarra-view
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
