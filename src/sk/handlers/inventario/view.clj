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
      {:id "chofer"
       :name "chofer"
       :class "easyui-combobox"
       :prompt "Por favor seleccione"
       :data-options "label:'Chofer:',
                     labelPosition:'top',
                     url:'/table_ref/choferes',
                     method:'GET',
                     required:true,
                     width:'100%'"})
    (build-field
      {:id "num_serie"
       :name "num_serie"
       :class "easyui-combobox"
       :prompt "Por favor seleccione"
       :data-options "label:'Numero de Serie:',
                     labelPosition:'top',
                     url:'/table_ref/nserie',
                     method:'GET',
                     required:true,
                     width:'100%'"})
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
    (build-radio-buttons "Llanta Delantera:" (build-radio-button "llanta_D"))
    (build-radio-buttons "Llanta Trasera:" (build-radio-button "llanta_T"))
    (build-radio-buttons "Direccionales:" (build-radio-button "direccionales"))
    (build-radio-buttons "Foco Delantero:" (build-radio-button "foco_del"))
    (build-radio-buttons "Cadena:" (build-radio-button "cadena"))
    (build-radio-buttons "Topes manublio derecho" (build-radio-button "topesmanubliod"))
    (build-radio-buttons "Topes manublio izquierdo" (build-radio-button "topesmanublioI"))
    (build-radio-buttons "Stop" (build-radio-button "stop"))
    (build-radio-buttons "Luz trasera" (build-radio-button "luztrasera"))
    (build-radio-buttons "Luz muerta Delantera" (build-radio-button "luzmuertaD"))
    (build-radio-buttons "Luz muerta Trasera" (build-radio-button "luzmuertaT"))
    (build-radio-buttons "Resorte Stand" (build-radio-button "ResorteStand"))
    (build-radio-buttons "Resorte Caballete" (build-radio-button "ResorteCaballete"))
    (build-radio-buttons "Bujes Rin Trasero" (build-radio-button "bujesRinT"))
    (build-radio-buttons "Bujias" (build-radio-button "Bujias"))
    (build-radio-buttons "Cable Cluth" (build-radio-button "CableCluth"))
    (build-radio-buttons "Cable Acelerador" (build-radio-button "CableAcel"))
    (build-radio-buttons "Cable Velocidades" (build-radio-button "CableVel"))
    (build-radio-buttons "Tapon Aceite" (build-radio-button "TaponAceite"))
    (build-radio-buttons "Micas Dirección Delantera" (build-radio-button "MicasDirD"))
    (build-radio-buttons "Micas Dirección Trasera" (build-radio-button "MicasDirT"))
    (build-radio-buttons "Claxon" (build-radio-button "claxon"))
    (build-radio-buttons "Orquilla Delantera" (build-radio-button "OrquillaDel"))
    (build-radio-buttons "Retenes" (build-radio-button "Retenes"))
    (build-radio-buttons "Nivel Aceite" (build-radio-button "NivelAceite"))
    (build-radio-buttons "Ajustadores Cadena" (build-radio-button "AjustadoresCad"))
    (build-radio-buttons "Guardafango" (build-radio-button "Guardafango"))
    (build-radio-buttons "Tapadera Lados" (build-radio-button "TapaderaLados"))
    (build-radio-buttons "Tapadera Filtro" (build-radio-button "TapaderaFiltro"))
    (build-radio-buttons "Tapadera Pila" (build-radio-button "TapaderaPila"))
    (build-radio-buttons "Balatas Delanteras" (build-radio-button "BalatasDel"))
    (build-radio-buttons "Balatas Traseras" (build-radio-button "BalatasTra"))
    (build-radio-buttons "Pila" (build-radio-button "Pila"))
    (build-radio-buttons "Selector Cambios" (build-radio-button "SelectorCambios"))
    (build-radio-buttons "Relay Direcciones" (build-radio-button "RelayDirecciones"))
    (build-radio-buttons "Guardacadenas" (build-radio-button "Guardacadenas"))
    (build-radio-buttons "Tope Asiento" (build-radio-button "TopeAsiento"))
    (build-radio-buttons "Hule Reposapie Izquierdo" (build-radio-button "HuleReposapieIzq"))
    (build-radio-buttons "Hule Reposapie Derecho" (build-radio-button "HuleReposapieDer"))
    (build-radio-buttons "Reposamano Freno Delantero" (build-radio-button "ReposamanoFrenoDel"))
    (build-radio-buttons "Cluth" (build-radio-button "Cluth"))
    (build-radio-buttons "Liquido Freno" (build-radio-button "LiquidoFreno"))
    (build-radio-buttons "Tolba Mofle" (build-radio-button "TolbaMofle"))
    (build-radio-buttons "ReposaPieCop Izquierdo" (build-radio-button "ReposaPieCop_Izq"))
    (build-radio-buttons "ReposaPieCop Derecho" (build-radio-button "ReposaPieCop_Der"))
    (build-radio-buttons "Herramienta" (build-radio-button  "Herramienta"))
    (build-radio-buttons "Switch Encendido" (build-radio-button "SwitchEncendido"))
    (build-radio-buttons "Switch Luces" (build-radio-button "SwitchLuces"))
    (build-radio-buttons "Switch Direccionales" (build-radio-button "SwitchDireccionales"))
    (build-radio-buttons "Estetica Tanque Gas" (build-radio-button "EsteticaTanqueGas"))
    (build-radio-buttons "Condiciones Marcadores" (build-radio-button "CondicionesMarcadores"))
    (build-radio-buttons "Bujes Orq Trasera" (build-radio-button "BujesOrqTra"))))

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
        [:th {:data-options "field:'chofer',sortable:true,fixed:false"
              :formatter "get_chofer"} [:span {:style "font-weight:bold;"} "Chofer"]]
        [:th {:data-options "field:'imagen',sortable:true,fixed:false,width:300"
              :formatter "imagenShow"} [:span {:style "font-weight:bold;"} "Foto"]]
        [:th {:data-options "field:'num_serie',sortable:true,fixed:false"
              :formatter "get_serie"} [:span {:style "font-weight:bold;"} "Numero de Serie"]]
        [:th {:data-options "field:'lec_odometro',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Lectura Odometro"]]
        [:th {:data-options "field:'fecha_formatted',sortable:true,fixed:false"} [:span {:style "font-weight:bold;"} "Fecha"]]
        ; (build-th "Retrovisores" "retrovisores")
        ; (build-th "Llanta Delantera" "llanta_D")
        ; (build-th "Llanta Trasera" "llanta_T")
        ; (build-th "Direccionales" "direccionales")
        ; (build-th "Foco Delantero" "foco_del")
        ; (build-th "Cadena" "cadena")
        ; (build-th "Topes manublio derecho" "topesmanubliod")
        ; (build-th "Topes manublio izquierdo" "topesmanublioI")
        ; (build-th "Stop" "stop")
        ; (build-th "Luz trasera" "luztrasera")
        ; (build-th "Luz muerta Delantera" "luzmuertaD")
        ; (build-th "Resorte Stand" "ResorteStand")
        ; (build-th "Resorte Caballete" "ResorteCaballete")
        ; (build-th "Bujes Rin Trasero" "bujesRinT")
        ; (build-th "Bujias" "Bujias")
        ; (build-th "Cable Cluth" "CableCluth")
        ; (build-th "Cable Acelerador" "CableAcel")
        ; (build-th "Cable Velocidades" "CableVel")
        ; (build-th "Tapon Aceite" "TaponAceite")
        ; (build-th "Micas Dirección Delantera" "MicasDirD")
        ; (build-th "Micas Dirección Trasera" "MicasDirT")
        ; (build-th "Claxon" "claxon")
        ; (build-th "Orquilla Delantera" "OrquillaDel")
        ; (build-th "Retenes" "Retenes")
        ; (build-th "Nivel Aceite" "NivelAceite")
        ; (build-th "Ajustadores Cadena" "AjustadoresCad")
        ; (build-th "Guardafango" "Guardafango")
        ; (build-th "Tapadera Lados" "TapaderaLados")
        ; (build-th "Tapadera Filtro" "TapaderaFiltro")
        ; (build-th "Tapadera Pila" "TapaderaPila")
        ; (build-th "Balatas Delanteras" "BalatasDel")
        ; (build-th "Balatas Traseras" "BalatasTra")
        ; (build-th "Pila" "Pila")
        ; (build-th "Selector Cambios" "SelectorCambios")
        ; (build-th "Relay Direcciones" "RelayDirecciones")
        ; (build-th "Guardacadenas" "Guardacadenas")
        ; (build-th "Tope Asiento" "TopeAsiento")
        ; (build-th "Hule Reposapie Izquierdo" "HuleReposapieIzq")
        ; (build-th "Hule Reposapie Derecho" "HuleReposapieDer")
        ; (build-th "Reposamano Freno Delantero" "ReposamanoFrenoDel")
        ; (build-th "Cluth" "Cluth")
        ; (build-th "Liquido Freno" "LiquidoFreno")
        ; (build-th "Tolba Mofle" "TolbaMofle")
        ; (build-th "ReposaPieCop Izquierdo" "ReposaPieCop_Izq")
        ; (build-th "ReposaPieCop Derecho" "ReposaPieCop_Der")
        ; (build-th "Herramienta" "Herramienta")
        ; (build-th "Switch Encendido" "SwitchEncendido")
        ; (build-th "Switch Luces" "SwitchLuces")
        ; (build-th "Switch Direccionales" "SwitchDireccionales")
        ; (build-th "Estetica Tanque Gas" "EsteticaTanqueGas")
        ; (build-th "Condiciones Marcadores" "CondicionesMarcadores")
        ;(build-th "Bujes Orq Trasera" "BujesOrqTra")
        ))
    (build-toolbar)
    (build-dialog title dialog-fields)))

(defn inventario-scripts []
  (list
  (include-js "/js/grid.js")
  [:script (build-image-field-script)
  (str
    "
    function get_chofer(val, row, index) {
      var valor = $.ajax({type: 'GET', url: '/table_ref/chofer/'+val, async: false}).responseText;
      return valor;
    }

    function get_serie(val, row, index) {
      var valor = $.ajax({type: 'GET', url: '/table_ref/serie/'+val, async: false}).responseText;
      return valor;
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
        let imgPath = " (:path config) ";
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
    ")]))
