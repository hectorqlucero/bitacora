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
  num_licencia varchar(20) DEFAULT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8")

(def choferes-rows
  [{:id 10
    :chofer "CARLOS"
    :tipo_licencia "C"
    :num_licencia "bc202104121210"}
   {:id 11
    :chofer "JUAN DE DIOS"}
   {:id 12
    :chofer "MARIO"}
   {:id 14
    :chofer "DANIEL NORIS"}
   {:id 15
    :chofer "ESTEBAN DE JESUS"
    :tipo_licencia "A"
    :num_licencia "bc202011013416"}
   {:id 16
    :chofer "JORGE ARMANDO"
    :tipo_licencia "C"
    :num_licencia "bc0405592367"}
   {:id 17
    :chofer "Charli Carlos"}
   {:id 18
    :chofer "Victor Leonardo"
    :tipo_licencia "C"
    :num_licencia "bc040849962"}
   {:id 19
    :chofer "Juan Ramon"
    :tipo_licencia "E"
    :num_licencia "bc040072081"}
   {:id 20
    :chofer "Jovany"}
   {:id 21
    :chofer "Tury"}
   {:id 22
    :chofer "Daniel Ruiz"}
   {:id 23
    :chofer "Carlos Rangel"}
   {:id 24
    :chofer "Rodrigo"}
   {:id 25
    :chofer "Brallan"}
   {:id 26
    :chofer "Jose Manuel"}
   {:id 27
    :chofer "Julian Horacio"
    :tipo_licencia "C"
    :num_licencia "BC040342894"}])
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
  UNIQUE INDEX num_serie (num_serie),
  CONSTRAINT fk_vehiculos_sucursal FOREIGN KEY (sucursal) REFERENCES sucursales(id),
  CONSTRAINT fk_vehiculos_chofer_asignado FOREIGN KEY (chofer_asignado) REFERENCES choferes(id)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8")

(def vehiculos-rows
  [{:id 1
    :vehiculo "suzuky"
    :num_serie "6221"
    :modelo "moto"
    :chofer_asignado 20
    :sucursal 12}
   {:id 2
    :vehiculo "susuky"
    :num_serie "2929"
    :chofer_asignado 22
    :sucursal 16}
   {:id 3
    :vehiculo "MOTO REGRESO SUZUKY"
    :num_serie "0207"
    :modelo "SEDEVOLVIO A SUZUKY"
    :chofer_asignado 20
    :sucursal 1}
   {:id 4
    :vehiculo "suzuky"
    :num_serie "6225"
    :chofer_asignado 11
    :sucursal 15}
   {:id 5
    :vehiculo "suzuky"
    :num_serie "0084"
    :chofer_asignado 17
    :sucursal 15}
   {:id 6
    :vehiculo "suzuky"
    :num_serie "7606"
    :chofer_asignado 27
    :sucursal 1}
   {:id 7
    :vehiculo "suzuky"
    :num_serie "5548"
    :chofer_asignado 18
    :sucursal 1}
   {:id 8
    :vehiculo "suzuky"
    :num_serie "3504"
    :chofer_asignado 23
    :sucursal 17}
   {:id 9
    :vehiculo "suzuky"
    :num_serie "2858"
    :chofer_asignado 19
    :sucursal 1}
   {:id 10
    :vehiculo "suzuky"
    :num_serie "3898"
    :chofer_asignado 16
    :sucursal 17}
   {:id 11
    :vehiculo "suzuky"
    :num_serie "2174"
    :chofer_asignado 24
    :sucursal 16}
   {:id 12
    :vehiculo "suzuky"
    :num_serie "3402"
    :chofer_asignado 15
    :sucursal 15}
   {:id 13
    :vehiculo "suzuky"
    :num_serie "7605"
    :chofer_asignado 10
    :sucursal 12}
   {:id 14
    :vehiculo "suzuky"
    :num_serie "1884"
    :chofer_asignado 25
    :sucursal 15}
   {:id 15
    :vehiculo "MOTO REGRESO SUZUKY"
    :num_serie "0156"
    :modelo "SE DEVOLVIO PARA SUZUKY"
    :chofer_asignado 10
    :sucursal 1}
   {:id 16
    :vehiculo "suzuky"
    :num_serie "3218"
    :chofer_asignado 26
    :sucursal 17}
   {:id 17
    :vehiculo "suzuky"
    :num_serie "1037"
    :modelo "MOTO"
    :chofer_asignado 27
    :sucursal 17}
   {:id 18
    :vehiculo "suzuky"
    :num_serie "3945"
    :modelo "MOTO"
    :chofer_asignado 14
    :sucursal 1}
   {:id 19
    :vehiculo "suzuky"
    :num_serie "3962"
    :modelo "MOTO"
    :chofer_asignado 12
    :sucursal 1}
   {:id 20
    :vehiculo "suzuky"
    :num_serie "2213"
    :modelo "MOTO"
    :chofer_asignado 21
    :sucursal 1}
   ])
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
  `chofer_id` int(10) NOT NULL,
  CONSTRAINT fk_inv_vehiculos_vehiculo_id FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id),
  CONSTRAINT fk_inv_vehiculos_chofere_id FOREIGN KEY (chofer_id) REFERENCES choferes(id)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8
  ")

(def inv_vehiculos-rows
  [{:id 1
    :vehiculo_id 5
    :lec_odometro 18982
    :fecha "2020-01-28"
    :retrovisores 4
    :llanta_d 1
    :llanta_t 1
    :direccionales 4
    :foco_del 4
    :cadena 4
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 2
    :luztrasera 2
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 1
    :balatastra 1
    :pila 1
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 17}
   {:id 2
    :vehiculo_id 15
    :lec_odometro 0
    :fecha "2020-09-30"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 4
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 4
    :balatastra 4
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 4
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 21}
   {:id 3
    :vehiculo_id 3
    :lec_odometro 15
    :fecha "2020-09-17"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 4
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 4
    :balatastra 4
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 4
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 14}
   {:id 4
    :vehiculo_id 17
    :lec_odometro 60150
    :fecha "2021-02-22"
    :retrovisores 1
    :llanta_d 4
    :llanta_t 1
    :direccionales 1
    :foco_del 4
    :cadena 1
    :topesmanubliod 1
    :topesmanublioi 1
    :stop 1
    :luztrasera 1
    :luzmuertad 1
    :luzmuertat 1
    :resortestand 4
    :resortecaballete 4
    :bujesrint 1
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 1
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 1
    :guardafango 4
    :tapaderalados 1
    :tapaderafiltro 1
    :tapaderapila 1
    :balatasdel 4
    :balatastra 4
    :pila 1
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 2
    :topeasiento 1
    :hulereposapieizq 1
    :hulereposapieder 1
    :reposamanofrenodel 1
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 1
    :reposapiecop_der 1
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 1
    :chofer_id 27}
   {:id 5
    :vehiculo_id 14
    :lec_odometro 57862
    :fecha "2020-08-08"
    :retrovisores 1
    :llanta_d 4
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 1
    :topesmanubliod 2
    :topesmanublioi 2
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 1
    :bujias 1
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 1
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 2
    :retenes 2
    :nivelaceite 4
    :ajustadorescad 1
    :guardafango 2
    :tapaderalados 1
    :tapaderafiltro 1
    :tapaderapila 1
    :balatasdel 1
    :balatastra 4
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 2
    :topeasiento 4
    :hulereposapieizq 1
    :hulereposapieder 1
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 1
    :tolbamofle 4
    :reposapiecop_izq 1
    :reposapiecop_der 1
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 2
    :condicionesmarcadores 4
    :bujesorqtra 1
    :chofer_id 25}
   {:id 6
    :vehiculo_id 11
    :lec_odometro 51861
    :fecha "2018-12-27"
    :retrovisores 4
    :llanta_d 2
    :llanta_t 1
    :direccionales 4
    :foco_del 4
    :cadena 1
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 2
    :luztrasera 2
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 2
    :bujias 1
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 1
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 1
    :balatastra 4
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 3
    :topeasiento 1
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 1
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 1
    :chofer_id 24}
   {:id 7
    :vehiculo_id 11
    :lec_odometro 67929
    :fecha "2021-02-05"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 1
    :direccionales 4
    :foco_del 4
    :cadena 1
    :topesmanubliod 2
    :topesmanublioi 4
    :stop 1
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 1
    :bujias 1
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 1
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 1
    :guardafango 4
    :tapaderalados 1
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 1
    :balatastra 4
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 2
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 1
    :tolbamofle 2
    :reposapiecop_izq 2
    :reposapiecop_der 2
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 1
    :condicionesmarcadores 4
    :bujesorqtra 1
    :chofer_id 24}
   {:id 8
    :vehiculo_id 20
    :lec_odometro 62
    :fecha "2021-02-24"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 4
    :topesmanubliod 2
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 4
    :balatastra 4
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 4
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 21}
   {:id 9
    :vehiculo_id 9
    :lec_odometro 35225
    :fecha "2020-11-13"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 4
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 1
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 1
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 2
    :balatastra 1
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 2
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 19}
   {:id 10
    :vehiculo_id 4
    :lec_odometro 4
    :fecha "2020-07-16"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 4
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 4
    :balatastra 4
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 4
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 22}
   {:id 11
    :vehiculo_id 12
    :lec_odometro 53472
    :fecha "2020-11-24"
    :retrovisores 1
    :llanta_d 4
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 1
    :topesmanubliod 2
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 2
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 1
    :balatastra 4
    :pila 1
    :selectorcambios 4
    :relaydirecciones 3
    :guardacadenas 2
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 2
    :reposapiecop_izq 2
    :reposapiecop_der 2
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 15}
   {:id 12
    :vehiculo_id 8
    :lec_odometro 34261
    :fecha "2020-10-02"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 1
    :direccionales 4
    :foco_del 4
    :cadena 1
    :topesmanubliod 2
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 4
    :balatastra 1
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 1
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 23}
   {:id 13
    :vehiculo_id 10
    :lec_odometro 35615
    :fecha "2021-01-28"
    :retrovisores 1
    :llanta_d 4
    :llanta_t 1
    :direccionales 4
    :foco_del 4
    :cadena 1
    :topesmanubliod 4
    :topesmanublioi 2
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 1
    :balatastra 1
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 1
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 1
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 16}
   {:id 14
    :vehiculo_id 18
    :lec_odometro 9
    :fecha "2021-02-22"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 4
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 4
    :balatastra 4
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 4
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 14}
   {:id 15
    :vehiculo_id 19
    :lec_odometro 7
    :fecha "2021-02-22"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 4
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 4
    :balatastra 4
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 4
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 12}
   {:id 16
    :vehiculo_id 7
    :lec_odometro 24719
    :fecha "2020-10-06"
    :retrovisores 1
    :llanta_d 1
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 4
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 1
    :balatastra 4
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 18}
   {:id 17
    :vehiculo_id 1
    :lec_odometro 0
    :fecha "2019-09-11"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 4
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 4
    :balatastra 4
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 20}
   {:id 18
    :vehiculo_id 4
    :lec_odometro 11606
    :fecha "2020-09-30"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 1
    :direccionales 4
    :foco_del 1
    :cadena 1
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 4
    :balatastra 1
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 11}
   {:id 19
    :vehiculo_id 13
    :lec_odometro 56074
    :fecha "2021-01-12"
    :retrovisores 4
    :llanta_d 4
    :llanta_t 1
    :direccionales 4
    :foco_del 4
    :cadena 1
    :topesmanubliod 2
    :topesmanublioi 2
    :stop 4
    :luztrasera 4
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 4
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 2
    :guardafango 1
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 1
    :balatastra 1
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 2
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 3
    :cluth 3
    :liquidofreno 1
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 1
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 10}
   {:id 20
    :vehiculo_id 6
    :lec_odometro 19329
    :fecha "2019-07-17"
    :retrovisores 4
    :llanta_d 1
    :llanta_t 4
    :direccionales 4
    :foco_del 4
    :cadena 4
    :topesmanubliod 4
    :topesmanublioi 4
    :stop 2
    :luztrasera 3
    :luzmuertad 4
    :luzmuertat 4
    :resortestand 4
    :resortecaballete 4
    :bujesrint 1
    :bujias 4
    :cablecluth 4
    :cableacel 4
    :cablevel 4
    :taponaceite 4
    :micasdird 4
    :micasdirt 4
    :claxon 4
    :orquilladel 4
    :retenes 4
    :nivelaceite 4
    :ajustadorescad 4
    :guardafango 4
    :tapaderalados 4
    :tapaderafiltro 4
    :tapaderapila 4
    :balatasdel 4
    :balatastra 1
    :pila 4
    :selectorcambios 4
    :relaydirecciones 4
    :guardacadenas 4
    :topeasiento 4
    :hulereposapieizq 4
    :hulereposapieder 4
    :reposamanofrenodel 4
    :cluth 4
    :liquidofreno 4
    :tolbamofle 4
    :reposapiecop_izq 4
    :reposapiecop_der 4
    :herramienta 2
    :switchencendido 4
    :switchluces 4
    :switchdireccionales 4
    :esteticatanqueGas 4
    :condicionesmarcadores 4
    :bujesorqtra 4
    :chofer_id 27}])
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
   {:id 12
    :sucursal "MICHUACAN"}
   {:id 15
    :sucursal "SANTA BARBARA"}
   {:id 16
    :sucursal "QUINTAS DEL REY"}
   {:id 17
    :sucursal "PEDREGAL"}])
;; ENd sucursales table

;; Start bitacora table
(def bitacora-sql
  "
  CREATE TABLE `bitacora` (
  `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fecha_reparacion` date NOT NULL,
  `desc_reparacion` varchar(100) NOT NULL,
  `observaciones` varchar(100) NOT NULL,
  `vehiculo_id` int(10) NOT NULL,
  CONSTRAINT fk_bitacora_vehiculos_vehiculo_id FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8
  ")

(def bitacora-rows
  [{:id 1
    :vehiculo_id 1
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

(defn drop-tables []
  (Query! db "DROP table IF EXISTS bitacora")
  (Query! db "DROP table IF EXISTS inv_vehiculos")
  (Query! db "DROP table IF EXISTS vehiculos")
  (Query! db "DROP table IF EXISTS choferes")
  (Query! db "DROP table IF EXISTS sucursales")
  (Query! db "DROP table IF EXISTS estado")
  (Query! db "DROP table IF EXISTS users"))

(defn create-tables []
  (Query! db users-sql)
  (Query! db estado-sql)
  (Query! db sucursales-sql)
  (Query! db choferes-sql)
  (Query! db vehiculos-sql)
  (Query! db inv_vehiculos-sql)
  (Query! db bitacora-sql))

(defn populate-tables []
  (Query! db "LOCK TABLES users WRITE;")
  (Insert-multi db :users users-rows)
  (Query! db "UNLOCK TABLES;")

  (Query! db "LOCK TABLES estado WRITE;")
  (Insert-multi db :estado estado-rows)
  (Query! db "UNLOCK TABLES;")

  (Query! db "LOCK TABLES sucursales WRITE;")
  (Insert-multi db :sucursales sucursales-rows)
  (Query! db "UNLOCK TABLES;")

  (Query! db "LOCK TABLES choferes WRITE;")
  (Insert-multi db :choferes choferes-rows)
  (Query! db "UNLOCK TABLES;")

  (Query! db "LOCK TABLES vehiculos WRITE;")
  (Insert-multi db :vehiculos vehiculos-rows)
  (Query! db "UNLOCK TABLES;")

  (Query! db "LOCK TABLES inv_vehiculos WRITE;")
  (Insert-multi db :inv_vehiculos inv_vehiculos-rows)
  (Query! db "UNLOCK TABLES;")

  (Query! db "LOCK TABLES bitacora WRITE;")
  (Insert-multi db :bitacora bitacora-rows)
  (Query! db "UNLOCK TABLES;"))

(defn reset-database
  "Removes existing tables and re-creates them"
  []
  (drop-tables)
  (create-tables)
  (populate-tables))
