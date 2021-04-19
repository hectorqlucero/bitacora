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
  UNIQUE INDEX num_serie (num_serie)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8")

(def vehiculos-rows
  [{:id 1
    :vehiculo "suzuky"
    :num_serie "6221"
    :modelo "moto"}
   {:id 2
    :vehiculo "susuky"
    :num_serie "2929"}
   {:id 3
    :vehiculo "MOTO REGRESO SUZUKY"
    :num_serie "0207"
    :modelo "SEDEVOLVIO A SUZUKY"}
   {:id 4
    :vehiculo "suzuky"
    :num_serie "6225"}
   {:id 5
    :vehiculo "suzuky"
    :num_serie "0084"}
   {:id 6
    :vehiculo "suzuky"
    :num_serie "7606"}
   {:id 7
    :vehiculo "suzuky"
    :num_serie "5548"}
   {:id 8
    :vehiculo "suzuky"
    :num_serie "3504"}
   {:id 9
    :vehiculo "suzuky"
    :num_serie "2858"}
   {:id 10
    :vehiculo "suzuky"
    :num_serie "3898"}
   {:id 11
    :vehiculo "suzuky"
    :num_serie "2174"}
   {:id 12
    :vehiculo "suzuky"
    :num_serie "3402"}
   {:id 13
    :vehiculo "suzuky"
    :num_serie "7605"}
   {:id 14
    :vehiculo "suzuky"
    :num_serie "1884"}
   {:id 15
    :vehiculo "MOTO REGRESO SUZUKY"
    :num_serie "0156"
    :modelo "SE DEVOLVIO PARA SUZUKY"}
   {:id 16
    :vehiculo "suzuky"
    :num_serie "3218"}
   {:id 17
    :vehiculo "suzuky"
    :num_serie "1037"
    :modelo "MOTO"}
   {:id 18
    :vehiculo "suzuky"
    :num_serie "3945"
    :modelo "MOTO"}
   {:id 19
    :vehiculo "suzuky"
    :num_serie "3962"
    :modelo "MOTO"}
   {:id 20
    :vehiculo "suzuky"
    :num_serie "2213"
    :modelo "MOTO"}
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
  `sucursal_id` int(10) NOT NULL,
  CONSTRAINT fk_inv_vehiculos_vehiculo_id FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_inv_vehiculos_chofere_id FOREIGN KEY (chofer_id) REFERENCES choferes(id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_inv_vehiculos_sucursal_id FOREIGN KEY (sucursal_id) REFERENCES sucursales(id) ON UPDATE CASCADE ON DELETE CASCADE
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
    :chofer_id 17
    :sucursal_id 15}
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
    :chofer_id 21
    :sucursal_id 1}
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
    :chofer_id 14
    :sucursal_id 1}
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
    :chofer_id 27
    :sucursal_id 17}
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
    :chofer_id 25
    :sucursal_id 15}
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
    :chofer_id 24
    :sucursal_id 16}
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
    :chofer_id 24
    :sucursal_id 16}
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
    :chofer_id 21
    :sucursal_id 1}
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
    :chofer_id 19
    :sucursal_id 1}
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
    :chofer_id 22
    :sucursal_id 15}
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
    :chofer_id 15
    :sucursal_id 15}
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
    :chofer_id 23
    :sucursal_id 17}
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
    :chofer_id 16
    :sucursal_id 17}
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
    :chofer_id 14
    :sucursal_id 1}
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
    :chofer_id 12
    :sucursal_id 1}
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
    :chofer_id 18
    :sucursal_id 1}
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
    :chofer_id 20
    :sucursal_id 12}
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
    :chofer_id 11
    :sucursal_id 15}
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
    :chofer_id 10
    :sucursal_id 12}
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
    :chofer_id 27
    :sucursal_id 1}])
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
  `sucursal_id` int(10) NOT NULL,
  CONSTRAINT fk_bitacora_vehiculos_vehiculo_id FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_bitacora_sucursal_id FOREIGN KEY (sucursal_id) REFERENCES sucursales(id) ON UPDATE CASCADE ON DELETE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8
  ")

(def bitacora-rows
  [
   {:id 1
    :fecha_reparacion "2020-01-28"
    :desc_reparacion "Cambio de Aceite"
    :observaciones "KMl"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 2
    :fecha_reparacion "2020-02-05"
    :desc_reparacion "Cambio de bujes rin trasero"
    :observaciones "KM20155"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 3
    :fecha_reparacion "2020-03-05"
    :desc_reparacion "Cambio de cadena y esprock trasero y delantero"
    :observaciones "KM21731"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 4
    :fecha_reparacion "2020-03-11"
    :desc_reparacion "Cambio de chicote del clochs"
    :observaciones "KM22100"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 5
    :fecha_reparacion "2020-04-07"
    :desc_reparacion "Cambio de bateria LTH"
    :observaciones "KM23836"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 6
    :fecha_reparacion "2020-05-06"
    :desc_reparacion "Cambio de balatas delanteras"
    :observaciones "KM25728"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 7
    :fecha_reparacion "2020-05-28"
    :desc_reparacion "Cambio de Aceite"
    :observaciones "KM27028"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 8
    :fecha_reparacion "2020-05-29"
    :desc_reparacion "Cambio de llanta delantera Horng Fortune"
    :observaciones "KM27100"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 9
    :fecha_reparacion "2020-06-27"
    :desc_reparacion "Cambio de chicote velocimetro"
    :observaciones "KM27606"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 10
    :fecha_reparacion "2020-07-01"
    :desc_reparacion "Cambio de llanta trasera Shinko lisa y bujia y soldada de rin trasero"
    :observaciones "KM27640"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 11
    :fecha_reparacion "2020-07-23"
    :desc_reparacion "Cambio de barras delanteras"
    :observaciones "KM28878"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 12
    :fecha_reparacion "2020-09-04"
    :desc_reparacion "Cambio de pata de cambios y chicote del clochs"
    :observaciones "KM31511"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 13
    :fecha_reparacion "2020-09-19"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM31943"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 14
    :fecha_reparacion "2020-11-09"
    :desc_reparacion "Cambio de balatas delanteras y traseras y esprock trasero delantero ISK JAPAN"
    :observaciones "KM34699"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 15
    :fecha_reparacion "2020-11-18"
    :desc_reparacion "Cambio de llanta delantera barilla de freno trasero guardafango balatas traseras"
    :observaciones "KM50600"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 16
    :fecha_reparacion "2020-11-26"
    :desc_reparacion "Cambio de cadena llanta trasera y control de ensendido SHINKO"
    :observaciones "KM35792"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 17
    :fecha_reparacion "2020-01-13"
    :desc_reparacion "Xcambio de llanta delantera SINKO y chicote del velocimetro"
    :observaciones "KM38085"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 18
    :fecha_reparacion "2021-03-01"
    :desc_reparacion "Cambio de pila LTH A07DY"
    :observaciones "KM40400"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 19
    :fecha_reparacion "2021-03-09"
    :desc_reparacion "Cambio de selector de cambios y cambio de esprock trasero"
    :observaciones "KM40794"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 20
    :fecha_reparacion "2021-03-19"
    :desc_reparacion "Cambio de balatas delanteras isk"
    :observaciones "KM41202"
    :vehiculo_id 5
    :sucursal_id 15}
   {:id 21
    :fecha_reparacion "2020-01-28"
    :desc_reparacion "Cambio de Aceite"
    :observaciones "KM16759"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 22
    :fecha_reparacion "2020-02-19"
    :desc_reparacion "Cambio de disco delantero"
    :observaciones "KM17942"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 23
    :fecha_reparacion "2020-04-15"
    :desc_reparacion "Cambio de cadena y esprock y ajuste balatas traseras"
    :observaciones "KM"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 24
    :fecha_reparacion "2020-05-21"
    :desc_reparacion "Cambio de llanta trasera SHINKO y delantera FURTUNE"
    :observaciones "KM 53262"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 25
    :fecha_reparacion "2020-05-27"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 53693"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 26
    :fecha_reparacion "2020-05-29"
    :desc_reparacion "Cambio del clochs"
    :observaciones "KM 53765"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 27
    :fecha_reparacion "2020-07-09"
    :desc_reparacion "Lavade de carburador y soldada de pata del esten"
    :observaciones "KM 56336"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 28
    :fecha_reparacion "2020-09-19"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 60215"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 29
    :fecha_reparacion "2020-09-24"
    :desc_reparacion "Cambio de llanta trasera SHINKO"
    :observaciones "KM 60233"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 30
    :fecha_reparacion "2020-10-02"
    :desc_reparacion "Cambio de pila LTH A07DY"
    :observaciones "KM 60694"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 31
    :fecha_reparacion "2020-10-05"
    :desc_reparacion "Cambio de barras delanteras guardafango balatas delanteras y caballete"
    :observaciones "KM 60829"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 32
    :fecha_reparacion "2020-12-10"
    :desc_reparacion "Cambio de balatas traseras JAPAN"
    :observaciones "KM 60901"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 33
    :fecha_reparacion "2021-01-07"
    :desc_reparacion "Recorte de cadena"
    :observaciones "KM 62321"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 34
    :fecha_reparacion "2021-01-13"
    :desc_reparacion "Cambio de baleros del rin trasero"
    :observaciones "KM 62690"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 35
    :fecha_reparacion "2021-02-04"
    :desc_reparacion "Cambio de sprock trasero y delantero y cadena"
    :observaciones "KM 63850"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 36
    :fecha_reparacion "2021-02-13"
    :desc_reparacion "Cambio de barras delanteras y caja de repartos"
    :observaciones "KM 64136"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 37
    :fecha_reparacion "2021-02-25"
    :desc_reparacion "Cambio de llanta delantera y balatas traseras"
    :observaciones "KM 64697"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 38
    :fecha_reparacion "2021-03-24"
    :desc_reparacion "Cambio de reten barra derecha"
    :observaciones "KM 66104"
    :vehiculo_id 14
    :sucursal_id 15}
   {:id 39
    :fecha_reparacion "2019-04-08"
    :desc_reparacion "Cambio de selector de cambios"
    :observaciones "KM"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 40
    :fecha_reparacion "2019-11-04"
    :desc_reparacion "Cambio de cadena y esprock delantero"
    :observaciones "KM"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 41
    :fecha_reparacion "2020-03-03"
    :desc_reparacion "Cambio de esprock trasero y palanca del clochs"
    :observaciones "KM"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 42
    :fecha_reparacion "2020-03-17"
    :desc_reparacion "Cambio de balatas traseras reconstruidas y chicote del velocimetro"
    :observaciones "KM 61190"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 43
    :fecha_reparacion "2020-04-22"
    :desc_reparacion "Cambio de palanca de clochs"
    :observaciones "KM 63175"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 44
    :fecha_reparacion "2020-05-05"
    :desc_reparacion "Cambio de balatas traseras y llanta SHINKO LISA"
    :observaciones "KM 63866"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 45
    :fecha_reparacion "2020-05-15"
    :desc_reparacion "Cambio de cadena y sprock trasero"
    :observaciones "KM 64416"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 46
    :fecha_reparacion "2020-05-28"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 65059"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 47
    :fecha_reparacion "2020-06-20"
    :desc_reparacion "Cmbio de barras delanteras"
    :observaciones "KM 66254"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 48
    :fecha_reparacion "2020-06-25"
    :desc_reparacion "Cambio del chicote del clochs"
    :observaciones "KM 66397"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 49
    :fecha_reparacion "2020-07-06"
    :desc_reparacion "Soldada del mofle y cambio de balatas delanteras ISK"
    :observaciones "KM 67178"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 50
    :fecha_reparacion "2020-07-09"
    :desc_reparacion "Cambio de llanta delantera AKTIB"
    :observaciones "KM 67346"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 51
    :fecha_reparacion "2020-09-04"
    :desc_reparacion "Cambio del chicote del clohs y soquet de luz trasera"
    :observaciones "KM 67918"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 52
    :fecha_reparacion "2020-09-15"
    :desc_reparacion "Cambio de aceite y soldada del caballete"
    :observaciones "KM 68020"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 53
    :fecha_reparacion "2020-12-05"
    :desc_reparacion "Cambio de palanca freno delantero y chicote del velocimetro y retenes de horquilla delantera"
    :observaciones "KM 68112"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 54
    :fecha_reparacion "2021-02-05"
    :desc_reparacion "Cambio de pila LTH y balatas traseras JAPAN retrovisores"
    :observaciones "KM 67929"
    :vehiculo_id 11
    :sucursal_id 16}
   {:id 55
    :fecha_reparacion "2019-12-05"
    :desc_reparacion "Cambio de cadena y porta cadena tope derecho"
    :observaciones "KM 17988"
    :vehiculo_id 9
    :sucursal_id 1}
   {:id 56
    :fecha_reparacion "2020-01-30"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 21070"
    :vehiculo_id 9
    :sucursal_id 1}
   {:id 57
    :fecha_reparacion "2020-02-11"
    :desc_reparacion "Cambio de balatas delanteras"
    :observaciones "KM 21649"
    :vehiculo_id 9
    :sucursal_id 1}
   {:id 58
    :fecha_reparacion "2020-04-13"
    :desc_reparacion "Cambio de llanta delantera SHINKO y chicote velocimetro"
    :observaciones "KM 25020"
    :vehiculo_id 9
    :sucursal_id 1}
   {:id 59
    :fecha_reparacion "2020-05-28"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 27519"
    :vehiculo_id 9
    :sucursal_id 1}
   {:id 60
    :fecha_reparacion "2020-06-25"
    :desc_reparacion "Cambio de bujes rin trasero y llanta trasera SHINKO"
    :observaciones "KM 28930"
    :vehiculo_id 9
    :sucursal_id 1}
   {:id 61
    :fecha_reparacion "2020-09-15"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 31092"
    :vehiculo_id 9
    :sucursal_id 1}
   {:id 62
    :fecha_reparacion "2020-10-16"
    :desc_reparacion "Cambio de cadena selector de cambios y esprock delantero"
    :observaciones "KM 32841"
    :vehiculo_id 9
    :sucursal_id 1}
   {:id 63
    :fecha_reparacion "2020-11-13"
    :desc_reparacion "Cambio de balatas delanteras ISK"
    :observaciones "KM 33712"
    :vehiculo_id 9
    :sucursal_id 1}
   {:id 64
    :fecha_reparacion "2021-02-02"
    :desc_reparacion "Cambio de chicote del clochs y resorte del esten"
    :observaciones "KM 35225"
    :vehiculo_id 9
    :sucursal_id 1}
   {:id 65
    :fecha_reparacion "2021-02-03"
    :desc_reparacion "Se le puso aumento balatas traseras"
    :observaciones "KM 35262"
    :vehiculo_id 9
    :sucursal_id 1}
   {:id 66
    :fecha_reparacion "2021-02-04"
    :desc_reparacion "Cambio de foco X dos barras led"
    :observaciones "KM 9685"
    :vehiculo_id 2
    :sucursal_id 16}
   {:id 67
    :fecha_reparacion "2021-02-27"
    :desc_reparacion "Cambio de llanta trasera marca SHINKO"
    :observaciones "KM 10702"
    :vehiculo_id 2
    :sucursal_id 16}
   {:id 68
    :fecha_reparacion "2021-03-22"
    :desc_reparacion "Cambio de cadena y aumento a las balatas traseras"
    :observaciones "KM 66374"
    :vehiculo_id 16
    :sucursal_id 17}
   {:id 69
    :fecha_reparacion "2021-04-08"
    :desc_reparacion "Cambio de chicote del clochs y balatas traseras marca japan"
    :observaciones "KM 66783"
    :vehiculo_id 16
    :sucursal_id 17}
   {:id 70
    :fecha_reparacion "2019-12-27"
    :desc_reparacion "Cambio de cadena"
    :observaciones "KM 35236"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 71
    :fecha_reparacion "2020-01-15"
    :desc_reparacion "Cambio de llanta trasera SHINKO"
    :observaciones "KM 36386"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 72
    :fecha_reparacion "2020-01-28"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 37309"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 73
    :fecha_reparacion "2020-02-29"
    :desc_reparacion "Cambio de balatas delanteras"
    :observaciones "KM 39483"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 74
    :fecha_reparacion "2020-03-12"
    :desc_reparacion "Cambio de llata delantera SHINKO y parrilla de caja"
    :observaciones "KM 40364"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 75
    :fecha_reparacion "2020-05-28"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 45384"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 76
    :fecha_reparacion "2020-06-11"
    :desc_reparacion "Cambio de bujes del rin trasero y sprock delantero"
    :observaciones "KM 46157"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 77
    :fecha_reparacion "2020-07-09"
    :desc_reparacion "Cambio de cadena y sprock trasero"
    :observaciones "KM 47764"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 78
    :fecha_reparacion "2020-07-23"
    :desc_reparacion "Cambio del soquet de luz de stop"
    :observaciones "KM 48701"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 79
    :fecha_reparacion "2020-08-20"
    :desc_reparacion "Cambio de balata delantera ISK"
    :observaciones "KM 50251"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 80
    :fecha_reparacion "2020-09-19"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 51887"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 81
    :fecha_reparacion "2020-11-26"
    :desc_reparacion "Cambio de pila"
    :observaciones "KM 53661"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 82
    :fecha_reparacion "2021-03-19"
    :desc_reparacion "Cambio de balatas delanteras marca isk y esprock trasero"
    :observaciones "KM 60057"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 83
    :fecha_reparacion "2021-03-24"
    :desc_reparacion "Se le cambio hambos retenes de horquillas y guardafango"
    :observaciones "KM 60328"
    :vehiculo_id 12
    :sucursal_id 15}
   {:id 84
    :fecha_reparacion "2019-01-07"
    :desc_reparacion "Cambio de cadena y balatas delanteras sixti"
    :observaciones "KM 16742"
    :vehiculo_id 8
    :sucursal_id 17}
   {:id 85
    :fecha_reparacion "2020-01-28"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 17876"
    :vehiculo_id 8
    :sucursal_id 17}
   {:id 86
    :fecha_reparacion "2020-05-22"
    :desc_reparacion "Cambio de llanta trasera shinko lisa"
    :observaciones "KM 25100"
    :vehiculo_id 8
    :sucursal_id 17}
   {:id 87
    :fecha_reparacion "2020-05-28"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 25582"
    :vehiculo_id 8
    :sucursal_id 17}
   {:id 88
    :fecha_reparacion "2020-06-13"
    :desc_reparacion "Cambio de cadena"
    :observaciones "KM 26673"
    :vehiculo_id 8
    :sucursal_id 17}
   {:id 89
    :fecha_reparacion "2020-09-17"
    :desc_reparacion "Cambio de aceite llanta delantera y spcock delantero"
    :observaciones "KM 33485"
    :vehiculo_id 8
    :sucursal_id 17}
   {:id 90
    :fecha_reparacion "2020-10-02"
    :desc_reparacion "Cambio bujes traseros y balatas delanteras isk"
    :observaciones "KM 34261"
    :vehiculo_id 8
    :sucursal_id 17}
   {:id 91
    :fecha_reparacion "2019-11-04"
    :desc_reparacion "Cambio de foco delantero x una barra led"
    :observaciones "KM 12421"
    :vehiculo_id 10
    :sucursal_id 17}
   {:id 92
    :fecha_reparacion "2020-01-28"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 16751"
    :vehiculo_id 10
    :sucursal_id 17}
   {:id 93
    :fecha_reparacion "2020-03-11"
    :desc_reparacion "Cambio de cadena"
    :observaciones "KM 19200"
    :vehiculo_id 10
    :sucursal_id 17}
   {:id 94
    :fecha_reparacion "2020-04-16"
    :desc_reparacion "Cambio de llanta trasera shinko lisa"
    :observaciones "KM 21398"
    :vehiculo_id 10
    :sucursal_id 17}
   {:id 95
    :fecha_reparacion "2020-04-23"
    :desc_reparacion "Cambio de chicote del clochs y pila lth"
    :observaciones "KM 21912"
    :vehiculo_id 10
    :sucursal_id 17}
   {:id 96
    :fecha_reparacion "2020-05-27"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 24546"
    :vehiculo_id 10
    :sucursal_id 17}
   {:id 97
    :fecha_reparacion "2020-06-11"
    :desc_reparacion "Cambio de llanta delantera aktrib y balatas delanteras isk"
    :observaciones "KM 25301"
    :vehiculo_id 10
    :sucursal_id 17}
   {:id 98
    :fecha_reparacion "2020-09-19"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 29668"
    :vehiculo_id 10
    :sucursal_id 17}
   {:id 99
    :fecha_reparacion "2021-02-11"
    :desc_reparacion "Cambio de manija del clochs"
    :observaciones "KM 36219"
    :vehiculo_id 10
    :sucursal_id 17}
   {:id 100
    :fecha_reparacion "2021-02-26"
    :desc_reparacion "Cambio de chicote del clochs"
    :observaciones "KM 36728"
    :vehiculo_id 10
    :sucursal_id 17}
   {:id 101
    :fecha_reparacion "2021-04-08"
    :desc_reparacion "Cambio de selector de cambios"
    :observaciones "KM 38286"
    :vehiculo_id 10
    :sucursal_id 17}
   {:id 102
    :fecha_reparacion "2019-04-08"
    :desc_reparacion "Cambio de aceite y cable del tacometro"
    :observaciones "KM 31337"
    :vehiculo_id 7
    :sucursal_id 1}
   {:id 103
    :fecha_reparacion "2020-01-28"
    :desc_reparacion "Cambio de Aceite"
    :observaciones "KM 10543"
    :vehiculo_id 7
    :sucursal_id 1}
   {:id 104
    :fecha_reparacion "2020-03-17"
    :desc_reparacion "Cambio de balatas delanteras sixti semi metal"
    :observaciones "KM 13126"
    :vehiculo_id 7
    :sucursal_id 1}
   {:id 105
    :fecha_reparacion "2020-04-13"
    :desc_reparacion "Cambio de llanta trasera shinko lisa"
    :observaciones "KM 14514"
    :vehiculo_id 7
    :sucursal_id 1}
   {:id 106
    :fecha_reparacion "2020-05-26"
    :desc_reparacion "Cambio de cadena"
    :observaciones "KM 16771"
    :vehiculo_id 7
    :sucursal_id 1}
   {:id 107
    :fecha_reparacion "2020-05-28"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 17509"
    :vehiculo_id 7
    :sucursal_id 1}
   {:id 108
    :fecha_reparacion "2020-09-08"
    :desc_reparacion "Cambio de balatas traseras"
    :observaciones "KM 23749"
    :vehiculo_id 7
    :sucursal_id 1}
   {:id 109
    :fecha_reparacion "2020-09-15"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 24199"
    :vehiculo_id 7
    :sucursal_id 1}
   {:id 110
    :fecha_reparacion "2020-11-11"
    :desc_reparacion "Cambio del chicote del clochs"
    :observaciones "KM 26503"
    :vehiculo_id 7
    :sucursal_id 1}
   {:id 111
    :fecha_reparacion "2021-01-13"
    :desc_reparacion "Cambio de llanta delantera shinko y balatas delanteras isk"
    :observaciones "KM 30294"
    :vehiculo_id 7
    :sucursal_id 1}
   {:id 112
    :fecha_reparacion "2021-02-18"
    :desc_reparacion "Cambio de foco delantero x una barrita led"
    :observaciones "KM"
    :vehiculo_id 7
    :sucursal_id 1}
   {:id 113
    :fecha_reparacion "2019-12-18"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 5395"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 114
    :fecha_reparacion "2020-01-28"
    :desc_reparacion "Cambio de Aceite"
    :observaciones "KM 7804"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 115
    :fecha_reparacion "2020-03-02"
    :desc_reparacion "Cambio de llanta trasera btr uberss"
    :observaciones "KM 9500"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 116
    :fecha_reparacion "2020-04-24"
    :desc_reparacion "Cambio de balatas delanteras y aumento a las balatas traseras"
    :observaciones "KM 12378"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 117
    :fecha_reparacion "2020-05-28"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 14599"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 118
    :fecha_reparacion "2020-06-02"
    :desc_reparacion "Cambio de cadena"
    :observaciones "KM 14893"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 119
    :fecha_reparacion "2020-06-20"
    :desc_reparacion "Cambio de chicote del clochs"
    :observaciones "KM 15953"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 120
    :fecha_reparacion "2020-09-15"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 21457"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 121
    :fecha_reparacion "2020-10-02"
    :desc_reparacion "Cambio de balatas traseras japan"
    :observaciones "KM 22456"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 122
    :fecha_reparacion "2020-10-09"
    :desc_reparacion "Cambio de llanta trasera shinko"
    :observaciones "KM 22855"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 123
    :fecha_reparacion "2020-11-18"
    :desc_reparacion "Cambio de llanta delantera"
    :observaciones "KM 26284"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 124
    :fecha_reparacion "2020-12-28"
    :desc_reparacion "Cambio de foco delantero x una barra led"
    :observaciones "KM 27532"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 125
    :fecha_reparacion "2021-01-25"
    :desc_reparacion "Cambio de balatas delanteras isk"
    :observaciones "KM 29160"
    :vehiculo_id 1
    :sucursal_id 12}
   {:id 126
    :fecha_reparacion "2020-09-15"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 10627"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 127
    :fecha_reparacion "2020-09-23"
    :desc_reparacion "Cambio de balatas delanteras y soldada de parrilla"
    :observaciones "KM 11118"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 128
    :fecha_reparacion "2020-10-10"
    :desc_reparacion "Se le puso una barra led"
    :observaciones "KM 12300"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 129
    :fecha_reparacion "2020-11-14"
    :desc_reparacion "Cambio de llanta trasera shinko"
    :observaciones "KM 14634"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 130
    :fecha_reparacion "2020-11-18"
    :desc_reparacion "Soldada de pata de cambios"
    :observaciones "KM 14906"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 131
    :fecha_reparacion "2020-12-17"
    :desc_reparacion "Cambio de balatas delanteras y aumento a balatas traseras"
    :observaciones "KM 17175"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 132
    :fecha_reparacion "2021-01-13"
    :desc_reparacion "Cambio de velocimetro"
    :observaciones "KM 17724"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 133
    :fecha_reparacion "2021-02-04"
    :desc_reparacion "Soldada de parrilla"
    :observaciones "KM 18789"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 134
    :fecha_reparacion "2021-02-11"
    :desc_reparacion "Se le recorto la cadena"
    :observaciones "KM 19180"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 135
    :fecha_reparacion "2021-02-16"
    :desc_reparacion "Cambio de chicote del clochs generico"
    :observaciones "KM 19473"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 136
    :fecha_reparacion "2021-03-01"
    :desc_reparacion "Refresada de parrilla de carga"
    :observaciones "KM 20247"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 137
    :fecha_reparacion "2021-03-26"
    :desc_reparacion "Cambio de cadena"
    :observaciones "KM 21722"
    :vehiculo_id 4
    :sucursal_id 15}
   {:id 138
    :fecha_reparacion "2019-03-02"
    :desc_reparacion "Cambio de llanta trasera shinko"
    :observaciones "KM 41030"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 139
    :fecha_reparacion "2020-02-04"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 42396"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 140
    :fecha_reparacion "2020-04-23"
    :desc_reparacion "Cambio de balatas traseras"
    :observaciones "KM 45416"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 141
    :fecha_reparacion "2020-05-22"
    :desc_reparacion "Cambio de sprock delantero"
    :observaciones "KM"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 142
    :fecha_reparacion "2020-05-28"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 47203"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 143
    :fecha_reparacion "2020-07-17"
    :desc_reparacion "Cambio de palanca del clochs"
    :observaciones "KM 49534"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 144
    :fecha_reparacion "2020-07-30"
    :desc_reparacion "Lavada del carburador"
    :observaciones "KM 49991"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 145
    :fecha_reparacion "2020-08-12"
    :desc_reparacion "Cambio de chicote del clochs"
    :observaciones "KM 50231"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 146
    :fecha_reparacion "2020-09-12"
    :desc_reparacion "Cambio de cadena y reparacion de barrilla freno trasero"
    :observaciones "KM 51842"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 147
    :fecha_reparacion "2020-09-18"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 52043"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 148
    :fecha_reparacion "2020-10-03"
    :desc_reparacion "Cambio del chicote del clochs"
    :observaciones "KM 52674"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 149
    :fecha_reparacion "2020-10-22"
    :desc_reparacion "Cambio del rin trasero y balatas traseras y delanteras japan isk"
    :observaciones "KM 53433"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 150
    :fecha_reparacion "2020-12-22"
    :desc_reparacion "Cambio de barrilla del freno trasero"
    :observaciones "KM 56008"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 151
    :fecha_reparacion "2021-01-12"
    :desc_reparacion "Cambio de llanta delantera shinko"
    :observaciones "KM 56074"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 152
    :fecha_reparacion "2021-01-19"
    :desc_reparacion "Cambio del chicote del clochs"
    :observaciones "KM 56230"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 153
    :fecha_reparacion "2021-04-08"
    :desc_reparacion "Lavada de carburador"
    :observaciones "KM 59144"
    :vehiculo_id 13
    :sucursal_id 12}
   {:id 154
    :fecha_reparacion "2019-12-30"
    :desc_reparacion "Cambio de foco x una barra led"
    :observaciones "KM 28424"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 155
    :fecha_reparacion "2020-01-28"
    :desc_reparacion "Cambio de Aceite"
    :observaciones "KM 30037"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 156
    :fecha_reparacion "2020-03-05"
    :desc_reparacion "Cambio del chicote del clochs"
    :observaciones "KM 31826"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 157
    :fecha_reparacion "2020-03-13"
    :desc_reparacion "Cambio de cadena sprock trasero y delantero"
    :observaciones "KM 32330"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 158
    :fecha_reparacion "2020-04-15"
    :desc_reparacion "Cambio de bateria lth"
    :observaciones "KM 34187"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 159
    :fecha_reparacion "2020-05-28"
    :desc_reparacion "Cambio de Aceite"
    :observaciones "KM 36563"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 160
    :fecha_reparacion "2020-06-02"
    :desc_reparacion "Cambio de balatas"
    :observaciones "KM 36930"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 161
    :fecha_reparacion "2020-07-09"
    :desc_reparacion "Cambio de llanta delantera aktib"
    :observaciones "KM 39498"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 162
    :fecha_reparacion "2020-08-21"
    :desc_reparacion "Cambio de llanta trasera shinko"
    :observaciones "KM 42260"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 163
    :fecha_reparacion "2020-09-01"
    :desc_reparacion "Cambio de balatas delanteras isk"
    :observaciones "KM 43056"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 164
    :fecha_reparacion "2020-09-18"
    :desc_reparacion "Cambio de aceite"
    :observaciones "KM 43990"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 165
    :fecha_reparacion "2020-09-30"
    :desc_reparacion "Cambio de balatas traseras"
    :observaciones "KM 44561"
    :vehiculo_id 6
    :sucursal_id 1}
   {:id 166
    :fecha_reparacion "2020-02-03"
    :desc_reparacion "Cambio de cadena y sprock trasero"
    :observaciones "KM 36930"
    :vehiculo_id 6
    :sucursal_id 1}
   ])
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
