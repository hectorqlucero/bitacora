(ns sk.routes
  (:require [compojure.core :refer [defroutes GET POST]]
            [cheshire.core :refer [generate-string]]
            [sk.handlers.home.handler :as home]
            [sk.handlers.registrar.handler :as registrar]
            [sk.handlers.tref.handler :as table_ref]))

(defroutes open-routes
  ;; Start table_ref
  (GET "/table_ref/get_users" [] (generate-string (table_ref/get-users)))
  (GET "/table_ref/validate_email/:email" [email] (generate-string (table_ref/get-users-email email)))
  (GET "/table_ref/months" [] (generate-string (table_ref/months)))
  (GET "/table_ref/years/:pyears/:nyears" [pyears nyears] (generate-string (table_ref/years pyears nyears)))
  (GET "/table_ref/levels" [] (generate-string (table_ref/level-options)))
  (GET "/table_ref/vehiculos" [] (generate-string (table_ref/get-vehiculos)))
  (GET "/table_ref/nseries" [] (generate-string (table_ref/get-nseries)))
  (GET "/table_ref/nserie/:id" [id] (generate-string (table_ref/get-nserie id)))
  (GET "/table_ref/v_serie/:vehiculo_id" [vehiculo_id] (table_ref/get-v_serie vehiculo_id))
  (GET "/table_ref/sucursales" [] (generate-string (table_ref/get-sucursales)))
  (GET "/table_ref/sucursal/:id" [id] (table_ref/get-sucursal id))
  (GET "/table_ref/choferes" [] (generate-string (table_ref/get-choferes)))
  (GET "/table_ref/v_chofer/:vehiculo_id" [vehiculo_id] (table_ref/get-v_chofer vehiculo_id))
  ;; End table_ref

  ;; Start home
  (GET "/" request [] (home/main request))
  (GET "/home/login" request [] (home/login request))
  (POST "/home/login" [username password] (home/login! username password))
  (GET "/home/logoff" [] (home/logoff))
  ;; End home

  ;; Start registrar
  (GET "/register" request [] (registrar/registrar request))
  (POST "/register" request [] (registrar/registrar! request))
  (GET "/rpaswd" request [] (registrar/reset-password request))
  (POST "/rpaswd" request [] (registrar/reset-password! request))
  (GET "/reset_password/:token" [token] (registrar/reset-jwt token))
  (POST "/reset_password" request [] (registrar/reset-jwt! request))
  ;; End registrar
  )
