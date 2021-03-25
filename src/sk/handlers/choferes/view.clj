(ns sk.handlers.choferes.view
  (:require [ring.util.anti-forgery :refer [anti-forgery-field]]
            [hiccup.page :refer [include-js]]
            [sk.models.util :refer [build-table
                                    build-toolbar
                                    build-dialog
                                    build-field
                                    build-radio-buttons]]))

(def dialog-fields
  (list
    [:input {:type "hidden" :id "id" :name "id"}]
    (build-field
      {:id "chofer"
       :name "chofer"
       :class "easyui-textbox"
       :data-options "label:'Chofer:',
                     labelPosition:'top',
                     required:true,
                     width:'100%'"})
    (build-radio-buttons
      "Tipo Licencia:"
      (list
        {:id "tipo_licencia_a"
         :name "tipo_licencia"
         :class "easyui-radiobutton"
         :value "A"
         :data-options "label:'A', checked:true"}
        {:id "tipo_licencia_b"
         :name "tipo_licencia"
         :class "easyui-radiobutton"
         :value "B"
         :data-options "label:'B'"}
        {:id "tipo_licencia_c"
         :name "tipo_licencia"
         :class "easyui-radiobutton"
         :value "C"
         :data-options "label:'C'"}
        {:id "tipo_licencia_d"
         :name "tipo_licencia"
         :class "easyui-radiobutton"
         :value "D"
         :data-options "label:'D'"}
        {:id "tipo_licencia_e"
         :name "tipo_licencia"
         :class "easyui-radiobutton"
         :value "E"
         :data-options "label:'E'"}
        {:id "tipo_licencia_f"
         :name "tipo_licencia"
         :class "easyui-radiobutton"
         :value "F"
         :data-options "label:'F'"}))
    (build-field
      {:id "num_licencia"
       :name "num_licencia"
       :class "easyui-textbox"
       :data-options "label:'Numero Licencia:',
                     labelPosition:'top',
                     required:true,
                     width:'100%'"})
    (build-field
      {:id "sucursal"
       :name "sucursal"
       :class "easyui-combobox"
       :prompt "Por favor seleccione"
       :data-options "label:'Sucursal:',
                     labelPosition:'top',
                     url:'/table_ref/sucursales',
                     method:'GET',
                     required:true,
                     width:'100%'"})))

(defn choferes-view [title]
  (list
    (anti-forgery-field)
    (build-table
      title
      "/choferes"
      (list
        [:th {:data-options "field:'chofer',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Chofer"]]
        [:th {:data-options "field:'tipo_licencia',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Tipo Licencia"]]
        [:th {:data-options "field:'num_licencia',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Numero Licencia"]]
        [:th {:data-options "field:'sucursal',sortable:true,fixed:false"
              :formatter "get_sucursal"} [:span {:style "font-weight:bold;"} "Sucursal"]]))
    (build-toolbar)
    (build-dialog title dialog-fields)))

(defn choferes-scripts []
  (list
  (include-js "/js/grid.js")
  [:script
   (str
     "
     function get_sucursal(val, row, index) {
      var valor = $.ajax({type: 'GET', url: '/table_ref/sucursal/'+val, async: false}).responseText;
      return valor;
     }
     ")]))
