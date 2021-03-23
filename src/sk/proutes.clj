(ns sk.proutes
  (:require [compojure.core :refer [defroutes GET POST]]
            [sk.handlers.admin.users.handler :as users]
            [sk.handlers.bitacora.handler :as bitacora]))

(defroutes proutes
  ;; Start users
  (GET "/admin/users"  req [] (users/users req))
  (POST "/admin/users" req [] (users/users-grid req))
  (GET "/admin/users/edit/:id" [id] (users/users-form id))
  (POST "/admin/users/save" req [] (users/users-save req))
  (POST "/admin/users/delete" req [] (users/users-delete req))
  ;; End users
  ;; Start bitacora
  (GET "/bitacora"  req [] (bitacora/bitacora req))
  (POST "/bitacora" req [] (bitacora/bitacora-grid req))
  (GET "/bitacora/edit/:id" [id] (bitacora/bitacora-form id))
  (POST "/bitacora/save" req [] (bitacora/bitacora-save req))
  (POST "/bitacora/delete" req [] (bitacora/bitacora-delete req))
  ;; End bitacora
  )
