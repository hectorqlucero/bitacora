(ns sk.models.cdb
  (:require [sk.models.crud :refer [db
                                    Query!
                                    Insert-multi]]
            [noir.util.crypt :as crypt]))


;; Start users table
(def users-sql
  "CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  lastname varchar(45) DEFAULT NULL,
  firstname varchar(45) DEFAULT NULL,
  username varchar(45) DEFAULT NULL,
  password TEXT DEFAULT NULL,
  dob date DEFAULT NULL,
  cell varchar(45) DEFAULT NULL,
  phone varchar(45) DEFAULT NULL,fax varchar(45) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  level char(1) DEFAULT NULL COMMENT 'A=Administrator,U=User,S=System',
  active char(1) DEFAULT NULL COMMENT 'T=Active,F=Not active'
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8")

(def users-rows
  [{:lastname  "User"
    :firstname "Regular"
    :username  "user@gmail.com"
    :password  (crypt/encrypt "user")
    :dob       "1957-02-07"
    :email     "user@gmail.com"
    :level     "U"
    :active    "T"}
   {:lastname "User"
    :firstname "Admin"
    :username "admin@gmail.com"
    :password (crypt/encrypt "admin")
    :dob "1957-02-07"
    :email "admin@gmail.com"
    :level "S"
    :active "T"}])
;; End users table

;; Start vehiculos table
(def vehiculos-sql
  "CREATE TABLE vehiculos (
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  vehiculo varchar(30) DEFAULT NULL,
  num_serie varchar(17) DEFAULT NULL,
  modelo varchar(45) DEFAULT NULL,
  modelo_ano varchar(10) DEFAULT NULL,
  chofer_asignado int(2) NOT NULL,
  sucursal int(10) NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8")

(def vehiculos-rows
  [{:id 1
    :vehiculo "NUEVO"
    :num_serie "LC6PCJK63H0003222"
    :modelo "EN1252017"
    :modelo_ano "2018"
    :chofer_asignado 3
    :sucursal 9}
   {:id 2
    :vehiculo "PESCASOFT PICK UP"
    :num_serie "28788SASHA123"
    :modelo "FORF"
    :modelo_ano "2019"
    :chofer_asignado 8
    :sucursal 9}
   {:id 3
    :vehiculo "moto kawasaqui 123"
    :num_serie "kwsk123"
    :modelo "123"
    :chofer_asignado 4
    :sucursal 9}
   {:id 4
    :vehiculo "trtrtr"
    :num_serie "rtrtr"
    :modelo "trtrt"
    :chofer_asignado 5
    :sucursal 1}
   {:id 5
    :vehiculo "popo"
    :num_serie "654"
    :modelo "ka"
    :modelo_ano "2020"
    :chofer_asignado 6
    :sucursal 1}
   {:id 6
    :vehiculo "45454"
    :num_serie "454545"
    :modelo "54"
    :modelo_ano "2018"
    :chofer_asignado 2
    :sucursal 9}
   {:id 7
    :vehiculo "3334111"
    :num_serie "11111"
    :modelo "1111"
    :modelo_ano "2017"
    :chofer_asignado 6
    :sucursal 1}])
;; End vehiculos table

;; Start choferes table
(def choferes-sql
  "CREATE TABLE choferes (
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  chofer varchar(45) DEFAULT NULL,
  tipo_licencia varchar(20) DEFAULT NULL,
  num_licencia varchar(20) NOT NULL,
  sucursal int(10) NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8")

(def choferes-rows
  [{:id 1
    :chofer "manuel lopez"
    :tipo_licencia "123456"
    :num_licencia 12121212
    :sucursal 1}
   {:id 2
    :chofer "Samuel"
    :tipo_licencia "z"
    :num_licencia 12345
    :sucursal 1}
   {:id 3
    :chofer "edgar"
    :tipo_licencia "qa"
    :num_licencia 1234567123
    :sucursal 6}
   {:id 4
    :chofer "B"
    :tipo_licencia "B"
    :num_licencia 12345
    :sucursal 6}
   {:id 5
    :chofer "Ramon"
    :tipo_licencia "A"
    :num_licencia 67676767
    :sucursal 1}
   {:id 6
    :chofer "Ricardo"
    :tipo_licencia "E"
    :num_licencia 55655656
    :sucursal 3}
   {:id 7
    :chofer "Ricardo Vega"
    :tipo_licencia "A"
    :num_licencia 123
    :sucursal 2}
   {:id 8
    :chofer "Ines"
    :tipo_licencia "A"
    :num_licencia 12121
    :sucursal 4}
   {:id 9
    :chofer "fffff"
    :tipo_licencia "E"
    :num_licencia 23434
    :sucursal 3}])
;; End choferes table

;; Start estado table
(def estado-sql
  "CREATE TABLE estado (
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  estado varchar(10) DEFAULT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8")

(def estado-rows
  [{:id 1
    :estado "REGULAR"}
   {:id 2
    :estado "MALO"}
   {:id 3
    :estado "ALGO BUENO"}
   {:id 4
    :estado "BUENO"}])
;; End estado table

;; Start inv_vehiculos table
(def inv_vehiculos-sql
  "
  CREATE TABLE `inv_vehiculos` (
  `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `num_serie` varchar(17) NOT NULL,
  `lec_odometro` int(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `retrovisores` varchar(45) DEFAULT NULL,
  `llanta_D` int(1) DEFAULT NULL,
  `LLANTA_T` int(1) DEFAULT NULL,
  `direccionales` int(1) DEFAULT NULL,
  `foco_del` int(1) DEFAULT NULL,
  `cadena` int(1) DEFAULT NULL,
  `topesmanubliod` int(1) DEFAULT NULL,
  `topesmanublioI` int(1) DEFAULT NULL,
  `stop` int(1) DEFAULT NULL,
  `luztrasera` int(1) DEFAULT NULL,
  `luzmuertaD` int(1) DEFAULT NULL,
  `luzmuertaT` int(1) DEFAULT NULL,
  `ResorteStand` int(1) DEFAULT NULL,
  `ResorteCaballete` int(1) DEFAULT NULL,
  `bujesRinT` int(1) DEFAULT NULL,
  `Bujias` int(1) DEFAULT NULL,
  `CableCluth` int(1) DEFAULT NULL,
  `CableAcel` int(1) DEFAULT NULL,
  `CableVel` int(1) DEFAULT NULL,
  `TaponAceite` int(1) DEFAULT NULL,
  `MicasDirD` int(1) DEFAULT NULL,
  `MicasDirT` int(1) DEFAULT NULL,
  `claxon` int(1) DEFAULT NULL,
  `OrquillaDel` int(1) DEFAULT NULL,
  `Retenes` int(1) DEFAULT NULL,
  `NivelAceite` int(1) DEFAULT NULL,
  `AjustadoresCad` int(1) DEFAULT NULL,
  `Guardafango` int(1) DEFAULT NULL,
  `TapaderaLados` int(1) DEFAULT NULL,
  `TapaderaFiltro` int(1) DEFAULT NULL,
  `TapaderaPila` int(1) DEFAULT NULL,
  `BalatasDel` int(1) DEFAULT NULL,
  `BalatasTra` int(1) DEFAULT NULL,
  `Pila` int(1) DEFAULT NULL,
  `SelectorCambios` int(1) DEFAULT NULL,
  `RelayDirecciones` int(1) DEFAULT NULL,
  `Guardacadenas` int(1) DEFAULT NULL,
  `TopeAsiento` int(1) DEFAULT NULL,
  `HuleReposapieIzq` int(1) DEFAULT NULL,
  `HuleReposapieDer` int(1) DEFAULT NULL,
  `ReposamanoFrenoDel` int(1) DEFAULT NULL,
  `Cluth` int(1) DEFAULT NULL,
  `LiquidoFreno` int(1) DEFAULT NULL,
  `TolbaMofle` int(1) DEFAULT NULL,
  `ReposaPieCop_Izq` int(1) DEFAULT NULL,
  `ReposaPieCop_Der` int(1) DEFAULT NULL,
  `Herramienta` int(1) DEFAULT NULL,
  `SwitchEncendido` int(1) DEFAULT NULL,
  `SwitchLuces` int(1) DEFAULT NULL,
  `SwitchDireccionales` int(1) DEFAULT NULL,
  `EsteticaTanqueGas` int(1) DEFAULT NULL,
  `CondicionesMarcadores` int(1) DEFAULT NULL,
  `BujesOrqTra` int(1) DEFAULT NULL,
  `chofer` int(2) NOT NULL,
  `imagen` varchar(100) DEFAULT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8
  ")

(def inv_vehiculos-rows
  [{:id 1
    :num_serie "28788SASHA123"
    :lec_odometro 45
    :fecha "2021-02-09"
    :retrovisores "1"
    :llanta_D 1
    :LLANTA_T 1
    :direccionales 1
    :foco_del 1
    :topesmanublioI 1
    :stop 1
    :CableAcel 1
    :CableVel 1
    :TaponAceite 1
    :MicasDirD 1
    :MicasDirT 1
    :claxon 1
    :OrquillaDel 1
    :Retenes 1
    :NivelAceite 4
    :AjustadoresCad 2
    :Guardafango 2
    :TapaderaLados 2
    :TapaderaFiltro 2
    :TapaderaPila 2
    :BalatasDel 2
    :BalatasTra 2
    :Pila 2
    :SelectorCambios 2
    :RelayDirecciones 2
    :Guardacadenas 2
    :TopeAsiento 2
    :HuleReposapieDer 1
    :ReposamanoFrenoDel 1
    :Cluth 1
    :LiquidoFreno 2
    :TolbaMofle 2
    :ReposaPieCop_Izq 2
    :ReposaPieCop_Der 2
    :Herramienta 2
    :SwitchEncendido 2
    :SwitchLuces 2
    :SwitchDireccionales 2
    :EsteticaTanqueGas 2
    :CondicionesMarcadores 2
    :BujesOrqTra 2
    :chofer 2}
   {:id 2
    :num_serie "28788SASHA123"
    :lec_odometro 23
    :fecha "2021-02-10"
    :chofer 1}
   {:id 3
    :num_serie "28788SASHA123"
    :lec_odometro 3434
    :fecha "2021-02-16"
    :retrovisores 2
    :llanta_D 2
    :LLANTA_T 2
    :direccionales 2
    :foco_del 2
    :cadena 2
    :topesmanubliod 2
    :topesmanublioI 2
    :stop 2
    :chofer 1}
   {:id 4
    :num_serie "kwsk123"
    :lec_odometro 333
    :fecha "2021-02-14"
    :retrovisores 2
    :llanta_D 2
    :stop 2
    :CondicionesMarcadores 1
    :BujesOrqTra 1
    :chofer 1}
   {:id 5
    :num_serie "LC6PCJK63H0003222"
    :lec_odometro 123434
    :SwitchLuces 1
    :CondicionesMarcadores 4
    :chofer 1}
   {:id 6
    :num_serie "LC6PCJK63H0003222"
    :lec_odometro 34
    :fecha "2021-02-09"
    :llanta_D 4
    :LLANTA_T 4
    :cadena 4
    :chofer 7}])
;; End inv_vehiculos table

;; Start sucursales table
(def sucursales-sql
  "
  CREATE TABLE `sucursales` (
  `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `sucursal` varchar(55) DEFAULT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8
  ")

(def sucursales-rows
  [{:id 1
    :sucursal "CALLE 11"}
   {:id 2
    :sucursal "VILLAS DEL REY"}
   {:id 3
    :sucursal "SANTA BARBARA"}
   {:id 4
    :sucursal "Michoacan"}
   {:id 5
    :sucursal "Valle de Puebla"}
   {:id 6
    :sucursal "Palaco"}])
;; ENd sucursales table

;; Start bitacora table
(def bitacora-sql
  "
  CREATE TABLE `bitacora` (
  `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `num_serie` varchar(17) NOT NULL,
  `fecha_reparacion` date NOT NULL,
  `desc_reparacion` varchar(100) NOT NULL,
  `observaciones` varchar(100) NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8
  ")

(def bitacora-rows
  [{:id 1
    :num_serie "LC6PCJK63H0003222"
    :fecha_reparacion "2020-12-25"
    :desc_reparacion "CAMBIO DE BUJES"
    :observaciones "MAL ESTADO DAÑADO"}])
;; End bitacora table

(defn create-database
  "Create database tables and default admin users
   Note: First create the database on MySQL with any client"
  []
  ;; Start users table
  (Query! db users-sql)
  (Query! db "LOCK TABLES users WRITE;")
  (Insert-multi db :users users-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End users table

  ;; Start sucursales table
  (Query! db sucursales-sql)
  (Query! db "LOCK TABLES sucursales WRITE;")
  (Insert-multi db :sucursales sucursales-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End sucursales table

  ;; Start choferes table
  (Query! db choferes-sql)
  (Query! db "LOCK TABLES choferes WRITE;")
  (Insert-multi db :choferes choferes-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End choferes table

  ;; Start vehiculos table
  (Query! db vehiculos-sql)
  (Query! db "LOCK TABLES vehiculos WRITE;")
  (Insert-multi db :vehiculos vehiculos-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End vehiculos table

  ;; Start estado table
  (Query! db estado-sql)
  (Query! db "LOCK TABLES estado WRITE;")
  (Insert-multi db :estado estado-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End estado table

  ;; Start inv_vehiculos table
  (Query! db inv_vehiculos-sql)
  (Query! db "LOCK TABLES inv_vehiculos WRITE;")
  (Insert-multi db :inv_vehiculos inv_vehiculos-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End inv_vehiculos table

  ;; Start bitacora table
  (Query! db bitacora-sql)
  (Query! db "LOCK TABLES bitacora WRITE;")
  (Insert-multi db :bitacora bitacora-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End bitacora table
  )

(defn reset-database
  "Removes existing tables and re-creates them"
  []
  ;; Start users table
  (Query! db "DROP table IF EXISTS users")
  (Query! db users-sql)
  (Query! db "LOCK TABLES users WRITE;")
  (Insert-multi db :users users-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End users table

  ;; Start sucursales table
  (Query! db "DROP table IF EXISTS sucursales")
  (Query! db sucursales-sql)
  (Query! db "LOCK TABLES sucursales WRITE;")
  (Insert-multi db :sucursales sucursales-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End sucursales table

  ;; Start choferes table
  (Query! db "DROP table IF EXISTS choferes")
  (Query! db choferes-sql)
  (Query! db "LOCK TABLES choferes WRITE;")
  (Insert-multi db :choferes choferes-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End choferes table

  ;; Start vehiculos table
  (Query! db "DROP table IF EXISTS vehiculos")
  (Query! db vehiculos-sql)
  (Query! db "LOCK TABLES vehiculos WRITE;")
  (Insert-multi db :vehiculos vehiculos-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End vehiculos table

  ;; Start estado table
  (Query! db "DROP table IF EXISTS estado")
  (Query! db estado-sql)
  (Query! db "LOCK TABLES estado WRITE;")
  (Insert-multi db :estado estado-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End estado table

  ;; Start inv_vehiculos table
  (Query! db "DROP table IF EXISTS inv_vehiculos")
  (Query! db inv_vehiculos-sql)
  (Query! db "LOCK TABLES inv_vehiculos WRITE;")
  (Insert-multi db :inv_vehiculos inv_vehiculos-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End inv_vehiculos table

  ;; Start bitacora table
  (Query! db "DROP table IF EXISTS bitacora")
  (Query! db bitacora-sql)
  (Query! db "LOCK TABLES bitacora WRITE;")
  (Insert-multi db :bitacora bitacora-rows)
  (Query! db "UNLOCK TABLES;")
  ;; End bitacora table
  )

(defn migrate []
  "Migrate by the seat of my pants")
