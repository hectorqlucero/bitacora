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
  active char(1) DEFAULT NULL COMMENT 'T=Active,F=Not active',
  imagen varchar(200) DEFAULT NULL
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
    :chofer "marco"
    :tipo_licencia "B"
    :num_licencia "yyuuu"
    :sucursal 7}
   {:id 5
    :chofer "Ramon"
    :tipo_licencia "A"
    :num_licencia 67676767676767
    :sucursal 1}
   {:id 6
    :chofer "Ricardo"
    :tipo_licencia "E"
    :num_licencia 55655656
    :sucursal 1}
   {:id 7
    :chofer "Ricardo Vega"
    :tipo_licencia "A"
    :num_licencia "BC123"
    :sucursal 1}
   {:id 8
    :chofer "Ines"
    :tipo_licencia "A"
    :num_licencia "12121RDRRTTRTRTRTRT"
    :sucursal 6}
   {:id 9
    :chofer "fffff"
    :tipo_licencia "E"
    :num_licencia "ffff"
    :sucursal 10}])
;; End choferes table

;; Start vehiculos table
(def vehiculos-sql
  "CREATE TABLE vehiculos (
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  vehiculo varchar(30) DEFAULT NULL,
  num_serie varchar(17) DEFAULT NULL,
  modelo varchar(45) DEFAULT NULL,
  modelo_ano varchar(10) DEFAULT NULL,
  chofer_asignado int(10) NOT NULL,
  sucursal int(10) NOT NULL,
  UNIQUE INDEX num_serie (num_serie)
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
  `vehiculo_id` int(10) NOT NULL,
  `lec_odometro` int(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `retrovisores` varchar(45) DEFAULT NULL,
  `llanta_d` int(10) DEFAULT NULL,
  `llanta_t` int(10) DEFAULT NULL,
  `direccionales` int(10) DEFAULT NULL,
  `foco_del` int(10) DEFAULT NULL,
  `cadena` int(10) DEFAULT NULL,
  `topesmanubliod` int(10) DEFAULT NULL,
  `topesmanublioi` int(10) DEFAULT NULL,
  `stop` int(10) DEFAULT NULL,
  `luztrasera` int(10) DEFAULT NULL,
  `luzmuertad` int(10) DEFAULT NULL,
  `luzmuertat` int(10) DEFAULT NULL,
  `resortestand` int(10) DEFAULT NULL,
  `resortecaballete` int(10) DEFAULT NULL,
  `bujesrint` int(10) DEFAULT NULL,
  `bujias` int(10) DEFAULT NULL,
  `cablecluth` int(10) DEFAULT NULL,
  `cableacel` int(10) DEFAULT NULL,
  `cablevel` int(10) DEFAULT NULL,
  `taponaceite` int(10) DEFAULT NULL,
  `micasdird` int(10) DEFAULT NULL,
  `micasdirt` int(10) DEFAULT NULL,
  `claxon` int(10) DEFAULT NULL,
  `orquilladel` int(1) DEFAULT NULL,
  `retenes` int(10) DEFAULT NULL,
  `nivelaceite` int(10) DEFAULT NULL,
  `ajustadorescad` int(10) DEFAULT NULL,
  `guardafango` int(10) DEFAULT NULL,
  `tapaderalados` int(10) DEFAULT NULL,
  `tapaderafiltro` int(10) DEFAULT NULL,
  `tapaderapila` int(10) DEFAULT NULL,
  `balatasdel` int(10) DEFAULT NULL,
  `balatastra` int(10) DEFAULT NULL,
  `pila` int(10) DEFAULT NULL,
  `selectorcambios` int(10) DEFAULT NULL,
  `relaydirecciones` int(10) DEFAULT NULL,
  `guardacadenas` int(10) DEFAULT NULL,
  `topeasiento` int(10) DEFAULT NULL,
  `hulereposapieizq` int(10) DEFAULT NULL,
  `hulereposapieder` int(10) DEFAULT NULL,
  `reposamanofrenodel` int(10) DEFAULT NULL,
  `cluth` int(10) DEFAULT NULL,
  `liquidofreno` int(10) DEFAULT NULL,
  `tolbamofle` int(10) DEFAULT NULL,
  `reposapiecop_izq` int(10) DEFAULT NULL,
  `reposapiecop_der` int(10) DEFAULT NULL,
  `herramienta` int(10) DEFAULT NULL,
  `switchencendido` int(10) DEFAULT NULL,
  `switchluces` int(10) DEFAULT NULL,
  `switchdireccionales` int(10) DEFAULT NULL,
  `esteticatanquegas` int(10) DEFAULT NULL,
  `condicionesmarcadores` int(10) DEFAULT NULL,
  `bujesorqtra` int(10) DEFAULT NULL,
  `imagen` varchar(100) DEFAULT NULL,
  UNIQUE INDEX vehiculo_id (vehiculo_id)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8
  ")

(def inv_vehiculos-rows
  [{:id 1
    :vehiculo_id "1"
    :lec_odometro 45
    :fecha "2021-02-09"
    :retrovisores "1"
    :llanta_d 1
    :llanta_t 1
    :direccionales 1
    :foco_del 1
    :topesmanublioi 1
    :stop 1
    :cableacel 1
    :cablevel 1
    :taponaceite 1
    :micasdird 1
    :micasdirt 1
    :claxon 1
    :orquilladel 1
    :retenes 1
    :nivelaceite 4
    :ajustadorescad 2
    :guardafango 2
    :tapaderalados 2
    :tapaderafiltro 2
    :tapaderapila 2
    :balatasdel 2
    :balatastra 2
    :pila 2
    :selectorcambios 2
    :relaydirecciones 2
    :guardacadenas 2
    :topeasiento 2
    :hulereposapieder 1
    :reposamanofrenodel 1
    :cluth 1
    :liquidofreno 2
    :tolbamofle 2
    :reposapiecop_izq 2
    :reposapiecop_der 2
    :herramienta 2
    :switchencendido 2
    :switchluces 2
    :switchdireccionales 2
    :esteticatanqueGas 2
    :condicionesmarcadores 2
    :bujesorqtra 2}
   {:id 2
    :vehiculo_id "2"
    :lec_odometro 23
    :fecha "2021-02-10"}
   {:id 3
    :vehiculo_id "3"
    :lec_odometro 3434
    :fecha "2021-02-16"
    :retrovisores 2
    :llanta_d 2
    :llanta_t 2
    :direccionales 2
    :foco_del 2
    :cadena 2
    :topesmanubliod 2
    :topesmanublioi 2
    :stop 2}
   {:id 4
    :vehiculo_id "4"
    :lec_odometro 333
    :fecha "2021-02-14"
    :retrovisores 2
    :llanta_d 2
    :stop 2
    :condicionesmarcadores 1
    :bujesorqtra 1}
   {:id 5
    :vehiculo_id "5"
    :lec_odometro 123434
    :switchluces 1
    :condicionesmarcadores 4}
   {:id 6
    :vehiculo_id "6"
    :lec_odometro 34
    :fecha "2021-02-09"
    :llanta_d 4
    :llanta_t 4
    :cadena 4}])
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
   {:id 4
    :sucursal "VILLAS DEL REY"}
   {:id 6
    :sucursal "SANTA BARBARA"}
   {:id 7
    :sucursal "Michoacan"}
   {:id 9
    :sucursal "Valle de Puebla"}
   {:id 10
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
  "Migrate by the seat of my pants"
  (Query! db "DROP table IF EXISTS inv_vehiculos")
  (Query! db inv_vehiculos-sql)
  (Query! db "LOCK TABLES inv_vehiculos  WRITE;")
  (Insert-multi db :inv_vehiculos inv_vehiculos-rows))
