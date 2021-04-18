(ns sk.proutes
  (:require [compojure.core :refer [defroutes GET POST]]
            [sk.handlers.admin.users.handler :as users]
            [sk.handlers.bitacora.handler :as bitacora]
            [sk.handlers.sucursales.handler :as sucursales]
            [sk.handlers.estado.handler :as estado]
            [sk.handlers.choferes.handler :as choferes]
            [sk.handlers.vehiculos.handler :as vehiculos]
            [sk.handlers.inventario.handler :as inventario]
            [sk.handlers.pizarra.handler :as pizarra]))

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

  ;; Start sucursales
  (GET "/sucursales"  req [] (sucursales/sucursales req))
  (POST "/sucursales" req [] (sucursales/sucursales-grid req))
  (GET "/sucursales/edit/:id" [id] (sucursales/sucursales-form id))
  (POST "/sucursales/save" req [] (sucursales/sucursales-save req))
  (POST "/sucursales/delete" req [] (sucursales/sucursales-delete req))
  ;; End sucursales

  ;; Start estado
  (GET "/estado"  req [] (estado/estado req))
  (POST "/estado" req [] (estado/estado-grid req))
  (GET "/estado/edit/:id" [id] (estado/estado-form id))
  (POST "/estado/save" req [] (estado/estado-save req))
  (POST "/estado/delete" req [] (estado/estado-delete req))
  ;; End estado

  ;; Start choferes
  (GET "/choferes"  req [] (choferes/choferes req))
  (POST "/choferes" req [] (choferes/choferes-grid req))
  (GET "/choferes/edit/:id" [id] (choferes/choferes-form id))
  (POST "/choferes/save" req [] (choferes/choferes-save req))
  (POST "/choferes/delete" req [] (choferes/choferes-delete req))
  ;; End choferes

  ;; Start vehiculos
  (GET "/vehiculos"  req [] (vehiculos/vehiculos req))
  (POST "/vehiculos" req [] (vehiculos/vehiculos-grid req))
  (GET "/vehiculos/edit/:id" [id] (vehiculos/vehiculos-form id))
  (POST "/vehiculos/save" req [] (vehiculos/vehiculos-save req))
  (POST "/vehiculos/delete" req [] (vehiculos/vehiculos-delete req))
  ;; End vehiculos

  ;; Start inventario
  (GET "/inventario"  req [] (inventario/inventario req))
  (POST "/inventario" req [] (inventario/inventario-grid req))
  (GET "/inventario/edit/:id" [id] (inventario/inventario-form id))
  (POST "/inventario/save" req [] (inventario/inventario-save req))
  (POST "/inventario/delete" req [] (inventario/inventario-delete req))
  ;; End inventario

  ;; Start pizarra
  (GET "/pizarra" req [] (pizarra/pizarra req))
  (GET "/pizarra/process/:id" [id] (pizarra/pizarra-process id))
  ;; ENd pizarra
  )
