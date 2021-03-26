(ns sk.handlers.vehiculos.view
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
       :class "easyui-combobox"
       :prompt "Por favor seleccione"
       :data-options "label:'Sucursal:',
                     labelPosition:'top',
                     url:'/table_ref/sucursales',
                     method:'GET',
                     required:true,
                     width:'100%'"})
    (build-field
      {:id "vehiculo"
       :name "vehiculo"
       :class "easyui-textbox"
       :data-options "label:'Vehiculo:',
                     labelPosition:'top',
                     required:true,
                     width:'100%'"})
    (build-field
      {:id "num_serie"
       :name "num_serie"
       :class "easyui-textbox"
       :data-options "label:'Numero de Serie:',
                     labelPosition:'top',
                     required:true,
                     width:'100%'"})
    (build-field
      {:id "modelo"
       :name "modelo"
       :class "easyui-textbox"
       :data-options "label:'Modelo:',
                     labelPosition:'top',
                     required:true,
                     width:'100%'"})
    (build-field
      {:id "modelo_ano"
       :name "modelo_ano"
       :class "easyui-textbox"
       :data-options "label:'Modelo Año:',
                     labelPosition:'top',
                     required:true,
                     width:'100%'"})
    (build-field
      {:id "chofer_asignado"
       :name "chofer_asignado"
       :class "easyui-combobox"
       :prompt "Por favor seleccione"
       :data-options "label:'Chofer Asignado:',
                     labelPosition:'top',
                     url:'/table_ref/choferes',
                     method:'GET',
                     required:true,
                     width:'100%'"})))

(defn vehiculos-view [title]
  (list
    (anti-forgery-field)
    (build-table
      title
      "/vehiculos"
      (list
        [:th {:data-options "field:'sucursal',sortable:true,fixed:false"
              :formatter "get_sucursal"} [:span {:style "font-weight:bold;"} "Sucursal"]]
        [:th {:data-options "field:'vehiculo',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Vehiculo"]]
        [:th {:data-options "field:'num_serie',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Numero de Serie"]]
        [:th {:data-options "field:'modelo',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Modelo"]]
        [:th {:data-options "field:'modelo_ano',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Modelo Año"]]
        [:th {:data-options "field:'id',sortable:true,fixed:false"
              :formatter "get_chofer"} [:span {:style "font-weight:bold;"} "Chofer Asignado"]]))
    (build-toolbar)
    (build-dialog title dialog-fields)))

(defn vehiculos-scripts []
  (list
  (include-js "/js/grid.js")
  [:script
   (str
     "
     function get_sucursal(val, row, index) {
      var valor = $.ajax({type: 'GET', url: '/table_ref/sucursal/'+val, async: false}).responseText;
      return valor;
     }

     function get_chofer(val, row, index) {
      var valor = $.ajax({type: 'GET', url: '/table_ref/v_chofer/'+val, async: false}).responseText;
      return valor
     }
     ")]))
