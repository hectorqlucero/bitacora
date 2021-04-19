(ns sk.handlers.pizarra.view
  (:require [sk.handlers.pizarra.sql :refer :all]
            [sk.models.util :refer [build-img-html
                                    build-field]]
            [sk.models.crud :refer [config Query db]])
  (:import [java.util UUID]))

;; Start vehiculos table
(defn build-vehiculos-row [row]
  [:tr
   [:td (:sucursal row)]
   [:td (:chofer row)]
   [:td (:vehiculo row)]
   [:td (:num_serie row)]
   [:td (:modelo row)]
   [:td (:modelo_ano row)]])

(defn build-vehiculo-table-body [rows]
  (map build-vehiculos-row rows))

(defn build-vehiculos-table [rows]
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
    (build-vehiculo-table-body rows)]])
;; End vehiculos table

;; Start bitacoras table
(defn build-bitacoras-row [row]
  [:tr
   [:td (:sucursal row)]
   [:td (:vehiculo row)]
   [:td (:num_serie row)]
   [:td (:modelo row)]
   [:td (:modelo_ano row)]
   [:td (:fecha_reparacion row)]
   [:td (:desc_reparacion row)]
   [:td (:observaciones row)]])

(defn build-bitacora-table-body [rows]
  (map build-bitacoras-row rows))

(defn build-bitacora-table [rows]
  [:table.table.caption-top.table-bordered.table-hover
   [:caption "Bitacora"]
   [:thead.thead-light
    [:tr
     [:th {:scope "col"} "Sucursal"]
     [:th {:scope "col"} "Vehiculo"]
     [:th {:scope "col"} "Numero de Serie"]
     [:th {:scope "col"} "Modelo"]
     [:th {:scope "col"} "Modelo Año"]
     [:th {:scope "col"} "Fecha de Reparacion"]
     [:th {:scope "col"} "Descripción de Reparacion"]
     [:th {:scope "col"} "Observaciones"]]
    [:tbody
     (build-bitacora-table-body rows)]]])
;; End bitacoras table

;; Start inv_vehiculos table
(defn build-inv_vehiculos-row [row]
  [:tr
   [:td (build-img-html (:imagen row) (str (UUID/randomUUID)) (:path config))]
   [:td (:sucursal row)]
   [:td (:chofer row)]
   [:td (:fecha row)]
   [:td (:vehiculo row)]
   [:td (:num_serie row)]
   [:td (:modelo row)]
   [:td (:modelo_ano row)]
   [:td (:lec_odometro row)]])

(defn build-inv_vehiculos-table-body [rows]
  (map build-inv_vehiculos-row rows))

(defn build-inv_vehiculos-table [rows]
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
     (build-inv_vehiculos-table-body rows)]]])
;; End ivn_vehiculos table

(defn pizarra-process-view
  [title vrows brows irows]
  (list
    [:div.container
     [:div.col-12.text-center
      [:h3 {:style "color:#158CBA;text-transform:uppercase;font-weight:bold;"} title]]
     [:hr]
     [:div.col-12.text-center {:style "margin-bottom:10px;"}
      (build-field
        {:id "sucursal"
         :name "sucursal"
         :class "easyui-combobox"
         :prompt "Por favor seleccione"
         :data-options "required:false,
                       width:'50%',
                       url:'/table_ref/sucursales',
                       method:'GET',
                       onSelect: function(rec) {
                       var uri = '/pizarra/process/'+rec.value;
                       window.location.replace(uri);
                       }"})]]
    [:h3 {:style "text-align:center;"} title]
    [:h4 "Bitacora"]
    [:div.table-responsive
     (build-bitacora-table brows)]
    [:h4 "Inventario de Vehiculos"]
    (build-inv_vehiculos-table irows)))

(defn pizarra-view 
  [title]
  (list
    [:div.container
     [:div.col-12.text-center
      [:h3 {:style "color:#158CBA;text-transform:uppercase;font-weight:bold;"} title]]
     [:hr]
     [:div.col-12.text-center {:style "margin-bottom:10px;"}
      (build-field
        {:id "sucursal"
         :name "sucursal"
         :class "easyui-combobox"
         :prompt "Por favor seleccione"
         :data-options "required:false,
                       width:'50%',
                       url:'/table_ref/sucursales',
                       method:'GET',
                       onSelect: function(rec) {
                       var uri = '/pizarra/process/'+rec.value;
                       window.location.replace(uri);
                       }"})
      ]
     ]))

(defn pizarra-scripts [])
