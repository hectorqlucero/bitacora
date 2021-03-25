(ns sk.handlers.bitacora.view
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
      {:id "num_serie"
       :name "num_serie"
       :class "easyui-combobox"
       :prompt "Por favor seleccione"
       :data-options "label:'Nuero de serie:',
                     labelPosition:'top',
                     url:'/table_ref/nserie',
                     method:'GET',
                     required:true,
                     width:'100%'"})
    (build-field
      {:id "fecha_reparacion"
       :name "fecha_reparacion"
       :class "easyui-datebox"
       :prompt "mm/dd/aaaa"
       :data-options "label:'Fecha de reparacion:',
                     labelPosition:'top',
                     required:true,
                     width:'100%'"})
    (build-field
      {:id "desc_reparacion"
       :name "desc_reparacion"
       :class "easyui-textbox"
       :data-options "label:'Descripción de Reparacion:',
                     labelPosition:'top',
                     required:true,
                     width:'100%'"})
    (build-field
      {:id "observaciones"
       :name "observaciones"
       :class "easyui-textbox"
       :data-options "label:'Observaciones:',
                     labelPosition:'top',
                     required:false,
                     width:'100%'"})))

(defn bitacora-view [title]
  (list
    (anti-forgery-field)
    (build-table
      title
      "/bitacora"
      (list
        [:th {:data-options "field:'num_serie',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Numero de Serie"]]
        [:th {:data-options "field:'fecha_reparacion_formatted',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Fecha de reparacion"]]
        [:th {:data-options "field:'desc_reparacion',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Descripción de Reparacion"]]
        [:th {:data-options "field:'observaciones',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Observaciones"]]))
    (build-toolbar)
    (build-dialog title dialog-fields)))

(defn bitacora-scripts []
  (include-js "/js/grid.js"))
