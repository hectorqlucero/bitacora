(ns sk.handlers.sucursales.view
  (:require [ring.util.anti-forgery :refer [anti-forgery-field]]
            [hiccup.page :refer [include-js]]
            [sk.models.util :refer [build-table
                                    build-toolbar
                                    build-dialog
                                    build-field]]))

(def dialog-fields
  (list
    [:input {:type "hidden" :id "id" :name "id"}]
    (build-field
      {:id "sucursal"
       :name "sucursal"
       :class "easyui-textbox"
       :data-options "label:'Sucursal:',
                     labelPosition:'top',
                     required:true,
                     width:'100%'"})))

(defn sucursales-view [title]
  (list
    (anti-forgery-field)
    (build-table
      title
      "/sucursales"
      (list
        [:th {:data-options "field:'id',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "ID"]]
        [:th {:data-options "field:'sucursal',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Sucursal"]]))
    (build-toolbar)
    (build-dialog title dialog-fields)))

(defn sucursales-scripts []
  (include-js "/js/grid.js"))
