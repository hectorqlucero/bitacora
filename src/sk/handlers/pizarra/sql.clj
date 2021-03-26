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
  s.sucursal,
  v.vehiculo,
  v.num_serie,
  v.modelo,
  v.modelo_ano,
  c.chofer
  FROM vehiculos v
  LEFT JOIN choferes c on v.chofer_asignado = c.id
  LEFT JOIN sucursales s on v.sucursal = s.id
  WHERE v.sucursal = ?")

;; Start bitacora
(def bitacora-sql
  "SELECT
  b.id,
  s.sucursal,
  c.chofer,
  v.vehiculo,
  b.num_serie,
  v.modelo,
  v.modelo_ano,
  DATE_FORMAT(b.fecha_reparacion,'%m/%d/%Y') as fecha_reparacion,
  b.desc_reparacion,
  b.observaciones
  FROM bitacora b
  LEFT JOIN vehiculos v on b.num_serie = v.num_serie
  LEFT JOIN choferes c on v.chofer_asignado = c.id
  LEFT JOIN sucursales s on v.sucursal = s.id
  ORDER BY v.sucursal,b.fecha_reparacion")

(defn bitacoras []
  (Query db bitacora-sql))
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
  LEFT JOIN vehiculos v on i.vehiculo_id = v.id
  LEFT JOIN choferes c on v.chofer_asignado = c.id
  LEFT JOIN sucursales s on v.sucursal = s.id
  ORDER BY v.sucursal,i.fecha")

(defn inv_vehiculos []
  (Query db inv_vehiculos-sql))
;; End inv_vehiculos
