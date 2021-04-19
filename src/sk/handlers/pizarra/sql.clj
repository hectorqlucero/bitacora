(ns sk.handlers.pizarra.sql
  (:require [sk.models.crud :refer [Query db]]))

;; Start sucursales
(def sucursales-sql
  "SELECT
  id,
  sucursal
  FROM sucursales
  ORDER BY sucursal ")

(defn sucursales []
  (Query db sucursales-sql))
;; End sucursales

(def vehiculos-sql
  "SELECT
  v.vehiculo,
  v.num_serie,
  v.modelo,
  v.modelo_ano,
  FROM vehiculos v
  WHERE v.sucursal = ?")

;; Start bitacora
(def bitacora-sql
  "SELECT
  b.id,
  s.sucursal,
  v.vehiculo,
  v.num_serie,
  v.modelo,
  v.modelo_ano,
  b.fecha_reparacion as fecha,
  DATE_FORMAT(b.fecha_reparacion,'%m/%d/%Y') as fecha_reparacion,
  b.desc_reparacion,
  b.observaciones
  FROM bitacora b
  LEFT JOIN vehiculos v on v.id = b.vehiculo_id
  LEFT JOIN sucursales s on s.id = b.sucursal_id
  WHERE b.sucursal_id = ?
  ORDER BY s.sucursal,fecha desc")

(defn bitacoras [sucursal_id]
  (Query db [bitacora-sql sucursal_id]))
;; End bitacoraa

;; Start inv_vehiculos
(def inv_vehiculos-sql
  "SELECT
  i.id,
  i.imagen,
  s.sucursal,
  c.chofer,
  v.vehiculo,
  v.modelo,
  v.modelo_ano,
  v.num_serie,
  i.lec_odometro,
  DATE_FORMAT(i.fecha,'%m/%d/%Y') as fecha
  FROM inv_vehiculos i
  LEFT JOIN vehiculos v on v.id = i.vehiculo_id
  LEFT JOIN choferes c on c.id = i.chofer_id
  LEFT JOIN sucursales s on s.id = i.sucursal_id
  WHERE i.sucursal_id = ?
  ORDER BY s.sucursal,i.fecha desc")

(defn inv_vehiculos [sucursal_id]
  (Query db [inv_vehiculos-sql sucursal_id]))
;; End inv_vehiculos
