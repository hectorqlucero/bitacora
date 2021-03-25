(ns sk.handlers.estado.view
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
      {:id "estado"
       :name "estado"
       :class "easyui-textbox"
       :data-options "label:'Estado:',
                     labelPosition:'top',
                     required:true,
                     width:'100%'"})))

(defn estado-view [title]
  (list
    (anti-forgery-field)
    (build-table
      title
      "/estado"
      (list
        [:th {:data-options "field:'id',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "ID"]]
        [:th {:data-options "field:'estado',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Estado"]]))
    (build-toolbar)
    (build-dialog title dialog-fields)))

(defn estado-scripts []
  (include-js "/js/grid.js"))
