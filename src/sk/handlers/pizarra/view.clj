(ns sk.handlers.pizarra.view
  (:require [sk.handlers.pizarra.sql :refer :all]
            [sk.models.crud :refer [config]]
            [sk.models.crud :refer [Query db]]))

;; Start vehiculos table
(defn build-vehiculos-row [row]
  [:tr
   [:td (:sucursal row)]
   [:td (:chofer row)]
   [:td (:vehiculo row)]
   [:td (:num_serie row)]
   [:td (:modelo row)]
   [:td (:modelo_ano row)]])

(defn build-vehiculo-table-body [row]
  (let [rows (Query db [vehiculos-sql (:id row)])]
    (map build-vehiculos-row rows)))

(defn build-vehiculos-table []
  [:table.table.caption-top.table-bordered.table-hover
   [:caption "Vehiculos"]
   [:thead.thead-light
    [:tr
     [:th {:scope "col"} "Sucursal"]
     [:th {:scope "col"} "Chofer"]
     [:th {:scope "col"} "Vehiculo"]
     [:th {:scope "col"} "Numero de Serie"]
     [:th {:scope "col"} "Modelo"]
     [:th {:scope "col"} "modelo Año"]]]
   [:tbody
    (map build-vehiculo-table-body (sucursales))]])
;; End vehiculos table

;; Start bitacoras table
(defn build-bitacoras-row [row]
  [:tr
   [:td (:sucursal row)]
   [:td (:chofer row)]
   [:td (:vehiculo row)]
   [:td (:num_serie row)]
   [:td (:modelo row)]
   [:td (:modelo_ano row)]
   [:td (:fecha_reparacion row)]
   [:td (:desc_reparacion row)]
   [:td (:observaciones row)]])

(defn build-bitacora-table-body []
  (map build-bitacoras-row (bitacoras)))

(defn build-bitacora-table []
  [:table.table.caption-top.table-bordered.table-hover
   [:caption "Bitacora"]
   [:thead.thead-light
    [:tr
     [:th {:scope "col"} "Sucursal"]
     [:th {:scope "col"} "Chofer"]
     [:th {:scope "col"} "Vehiculo"]
     [:th {:scope "col"} "Numero de Serie"]
     [:th {:scope "col"} "Modelo"]
     [:th {:scope "col"} "Modelo Año"]
     [:th {:scope "col"} "Fecha de Reparacion"]
     [:th {:scope "col"} "Descripción de Reparacion"]
     [:th {:scope "col"} "Observaciones"]]
    [:tbody
     (build-bitacora-table-body)]]])
;; End bitacoras table

;; Start inv_vehiculos table
(defn build-inv_vehiculos-row [row]
  [:tr
   [:td [:img {:src (str (:path config) (:imagen row))
               :width "90"
               :height "100"
               :onError "this.src='/images/placeholder_profile.png'"}]]
   [:td (:sucursal row)]
   [:td (:chofer row)]
   [:td (:fecha row)]
   [:td (:vehiculo row)]
   [:td (:num_serie row)]
   [:td (:modelo row)]
   [:td (:modelo_ano row)]
   [:td (:lec_odometro row)]])

(defn build-inv_vehiculos-table-body []
  (map build-inv_vehiculos-row (inv_vehiculos)))

(defn build-inv_vehiculos-table []
  [:table.table.caption-top.table-bordered.table-hover
   [:caption "Inventario de Vehiculos"]
   [:thead.thead-light
    [:tr
     [:th {:scope "col"} "Imagen"]
     [:th {:scope "col"} "Sucursal"]
     [:th {:scope "col"} "Chofer"]
     [:th {:scope "col"} "Fecha"]
     [:th {:scope "col"} "Vehiculo"]
     [:th {:scope "col"} "Numero de Serie"]
     [:th {:scope "col"} "Modelo"]
     [:th {:scope "col"} "Modelo Año"]
     [:th {:scope "col"} "Lecura de Odometro"]]
    [:tbody
     (build-inv_vehiculos-table-body)]]])
;; End ivn_vehiculos table

(defn pizarra-view [title]
  (list
    [:h3 {:style "text-align:center;"} title]
    [:h4 "Vehiculos"]
    [:div.table-responsive
     (build-vehiculos-table)]
    [:h4 "Bitacora"]
    [:div.table-responsive
     (build-bitacora-table)]
    [:h4 "Inventario de Vehiculos"]
    [:div.table-responsive
     (build-inv_vehiculos-table)]))

(defn pizarra-scripts [])
