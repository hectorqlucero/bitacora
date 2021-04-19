(ns sk.handlers.inventario.view
  (:require [ring.util.anti-forgery :refer [anti-forgery-field]]
            [hiccup.page :refer [include-js]]
            [sk.models.crud :refer [config]]
            [sk.models.util :refer [build-table
                                    build-toolbar
                                    build-dialog
                                    build-radio-buttons
                                    build-image-field
                                    build-image-field-script
                                    build-field]]))

(defn build-radio-button [field]
  (list
    {:id (str field "_4")
     :name field
     :class "easyui-radiobutton"
     :value "4"
     :data-options "label:'Bueno'"}
    {:id (str field "_2")
     :name field
     :class "easyui-radiobutton"
     :value "2"
     :data-options "label:'Malo'"}
    {:id (str field "_1")
     :name field
     :class "easyui-radiobutton"
     :value "1"
     :data-options "label:'Regular'"}))

(def dialog-fields
  (list
    [:input {:type "hidden" :id "id" :name "id"}]
    (build-image-field)
    (build-field
      {:id "sucursal_id"
       :name "sucursal_id"
       :class "easyui-combobox"
       :prompt "Por favor seleccione"
       :data-options "label:'Sucursal:',
                     labelPosition:'top',
                     required:true,
                     width:'100%',
                     url:'/table_ref/sucursales',
                     method:'GET'"})
    (build-field
      {:id "chofer_id"
       :name "chofer_id"
       :class "easyui-combobox"
       :prompt "Por favor seleccione"
       :data-options "label:'Chofer:',
                     labelPosition:'top',
                     required:true,
                     width:'100%',
                     url:'/table_ref/choferes',
                     method:'GET'"})
    (build-field
      {:id "vehiculo_id"
       :name "vehiculo_id"
       :class "easyui-combobox"
       :prompt "Por favor seleccione"
       :data-options "label:'Vehiculo:',
                     labelPosition:'top',
                     required:true,
                     width:'100%',
                     url:'/table_ref/vehiculos',
                     method:'GET'"})
    (build-field
      {:id "lec_odometro"
       :name "lec_odometro"
       :class "easyui-numberbox"
       :data-options "label:'Lectura Odometro:',
                     labelPosition:'top',
                     min:0,
                     precision:0,
                     required:true,
                     width:'100%'"})
    (build-field
      {:id "fecha"
       :name "fecha"
       :class "easyui-datebox"
       :prompt "mm/dd/yyy"
       :data-options "label:'Fecha:',labelPosition:'top',required:true,width:'100%'"})
    (build-radio-buttons "Retrovisores:" (build-radio-button "retrovisores"))
    (build-radio-buttons "Llanta Delantera:" (build-radio-button "llanta_d"))
    (build-radio-buttons "Llanta Trasera:" (build-radio-button "llanta_t"))
    (build-radio-buttons "Direccionales:" (build-radio-button "direccionales"))
    (build-radio-buttons "Foco Delantero:" (build-radio-button "foco_del"))
    (build-radio-buttons "Cadena:" (build-radio-button "cadena"))
    (build-radio-buttons "Topes manublio derecho" (build-radio-button "topesmanubliod"))
    (build-radio-buttons "Topes manublio izquierdo" (build-radio-button "topesmanublioi"))
    (build-radio-buttons "Stop" (build-radio-button "stop"))
    (build-radio-buttons "Luz trasera" (build-radio-button "luztrasera"))
    (build-radio-buttons "Luz muerta Delantera" (build-radio-button "luzmuertad"))
    (build-radio-buttons "Luz muerta Trasera" (build-radio-button "luzmuertat"))
    (build-radio-buttons "Resorte Stand" (build-radio-button "resortestand"))
    (build-radio-buttons "Resorte Caballete" (build-radio-button "resortecaballete"))
    (build-radio-buttons "Bujes Rin Trasero" (build-radio-button "bujesrint"))
    (build-radio-buttons "Bujias" (build-radio-button "bujias"))
    (build-radio-buttons "Cable Cluth" (build-radio-button "cablecluth"))
    (build-radio-buttons "Cable Acelerador" (build-radio-button "cableacel"))
    (build-radio-buttons "Cable Velocidades" (build-radio-button "cablevel"))
    (build-radio-buttons "Tapon Aceite" (build-radio-button "taponaceite"))
    (build-radio-buttons "Micas Dirección Delantera" (build-radio-button "micasdird"))
    (build-radio-buttons "Micas Dirección Trasera" (build-radio-button "micasdirt"))
    (build-radio-buttons "Claxon" (build-radio-button "claxon"))
    (build-radio-buttons "Orquilla Delantera" (build-radio-button "orquilladel"))
    (build-radio-buttons "Retenes" (build-radio-button "retenes"))
    (build-radio-buttons "Nivel Aceite" (build-radio-button "nivelaceite"))
    (build-radio-buttons "Ajustadores Cadena" (build-radio-button "ajustadorescad"))
    (build-radio-buttons "Guardafango" (build-radio-button "guardafango"))
    (build-radio-buttons "Tapadera Lados" (build-radio-button "tapaderalados"))
    (build-radio-buttons "Tapadera Filtro" (build-radio-button "tapaderafiltro"))
    (build-radio-buttons "Tapadera Pila" (build-radio-button "tapaderapila"))
    (build-radio-buttons "Balatas Delanteras" (build-radio-button "balatasdel"))
    (build-radio-buttons "Balatas Traseras" (build-radio-button "balatastra"))
    (build-radio-buttons "Pila" (build-radio-button "pila"))
    (build-radio-buttons "Selector Cambios" (build-radio-button "selectorcambios"))
    (build-radio-buttons "Relay Direcciones" (build-radio-button "relaydirecciones"))
    (build-radio-buttons "Guardacadenas" (build-radio-button "guardacadenas"))
    (build-radio-buttons "Tope Asiento" (build-radio-button "topeasiento"))
    (build-radio-buttons "Hule Reposapie Izquierdo" (build-radio-button "hulereposapieizq"))
    (build-radio-buttons "Hule Reposapie Derecho" (build-radio-button "hulereposapieder"))
    (build-radio-buttons "Reposamano Freno Delantero" (build-radio-button "reposamanofrenodel"))
    (build-radio-buttons "Cluth" (build-radio-button "cluth"))
    (build-radio-buttons "Liquido Freno" (build-radio-button "liquidofreno"))
    (build-radio-buttons "Tolba Mofle" (build-radio-button "tolbamofle"))
    (build-radio-buttons "ReposaPieCop Izquierdo" (build-radio-button "reposapiecop_izq"))
    (build-radio-buttons "ReposaPieCop Derecho" (build-radio-button "reposapiecop_der"))
    (build-radio-buttons "Herramienta" (build-radio-button  "herramienta"))
    (build-radio-buttons "Switch Encendido" (build-radio-button "switchencendido"))
    (build-radio-buttons "Switch Luces" (build-radio-button "switchluces"))
    (build-radio-buttons "Switch Direccionales" (build-radio-button "switchdireccionales"))
    (build-radio-buttons "Estetica Tanque Gas" (build-radio-button "esteticatanquegas"))
    (build-radio-buttons "Condiciones Marcadores" (build-radio-button "condicionesmarcadores"))
    (build-radio-buttons "Bujes Orq Trasera" (build-radio-button "bujesorqtra"))))

(defn build-th [label field]
  [:th {:data-options (str "field:'"field "',sortable:true,fixed:false")
        :formatter "get_desc"}
   [:span {:style "font-weight:bold;"} label]])

(defn inventario-view [title]
  (list
    (anti-forgery-field)
    (build-table
      title
      "/inventario"
      (list
        [:th {:data-options "field:'sucursal_id_formatted',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Sucursal"]]
        [:th {:data-options "field:'chofer_id_formatted',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Chofer"]]
        [:th {:data-options "field:'imagen',sortable:true,fixed:false"
              :formatter "imagenShow"} [:span {:style "font-weight:bold;"} "Foto"]]
        [:th {:data-options "field:'num_serie',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Numero de Serie"]]
        [:th {:data-options "field:'lec_odometro',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Lectura Odometro"]]
        [:th {:data-options "field:'fecha_formatted',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Fecha"]]
        ))
    (build-toolbar)
    (build-dialog title dialog-fields)))

(defn inventario-scripts []
  (list
  (include-js "/js/grid.js")
  [:script 
  (str
    "
    function newItem() {
      let the_url = '/table_ref/vehiculos';
      dg.datagrid('unselectAll');
      $('#image1').attr('src','/images/placeholder_profile.png');
      dlg.dialog('open').dialog('center').dialog('setTitle', 'Nuevo Record');
      windowHeight = $(window).height() - ($(window).height() * 0.2);
      dlg.dialog('resize', {height: windowHeight}).dialog('center');
      fm.form('clear');
      $('#vehiculo_id').combobox('readonly', false);
      $('#vehiculo_id').combobox('reload', the_url);
      url = window.location.href;
    }

    function resizeImage(imgObject) {
      var img = $('#'+imgObject.id);
      if(img.width() < 500) {
        img.animate({width: '500', height: '500'}, 1000);
      } else {
        img.animate({width: img.attr(\"width\"), height: img.attr(\"height\")}, 1000);
      }
    }

    function imagenShow(val, row, index) {
      if(row.imagen !== null) {
        let d = new Date();
        let imgValue = val;
        let imgError = 'this.src=\"/images/placeholder_profile.png\"';
        let imgPath = '" (:path config) "';
        console.log(imgPath);
        let imgSrc = imgPath + imgValue + '?' + d.getTime();
        let imgTag = '<img id=img'+index+' src='+imgSrc+' onError='+imgError+' width=95 height=71 onclick=resizeImage(this) />';
        return imgTag;
      } else {
        return row.imagen;
      }
    }

    function get_desc(val, row, index) {
      if(val == 1) {
        return 'Regular';
      } else if (val == 2) {
        return 'Malo';
      } else if (val == 3) {
        return 'Algo Bueno';
      } else if (val == 4) {
        return 'Bueno';
      }
    }

    $('.dlg').dialog({
      onOpen: function() {
        let the_url = '/table_ref/unique_vehiculos';
      }
    });

    $('.fm').form({
      onLoadSuccess: function(){
        let d = new Date();
        let imgValue = $('#imagen').val();
        let imgPath = '" (:path config) "';
        let imgSrc = imgPath + imgValue + '?' + d.getTime();
        let the_url = '/table_ref/vehiculos';
        let valor = $('#vehiculo_id').combobox('getValue');
        if(valor) {
          $('#vehiculo_id').combobox('reload', the_url);
          $('#vehiculo_id').combobox('readonly', true);
        }
        $('#image1').attr('src', imgSrc);
      }
    });
    
    $('#image1').click(function() {
      var img = $('#image1');
      if(img.width() < 500) {
        img.animate({width: '500', height: '500'}, 1000);
      } else {
        img.animate({width: img.attr(\"width\"), height: img.attr(\"height\")}, 1000);
      }
    });
    "
    )]
  ))
