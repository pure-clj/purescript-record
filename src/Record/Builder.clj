(ns Record.Builder._foreign
  (:require [clojure.set :refer [rename-keys]]))

(defn copyRecord [rec]
  rec)

(defn unsafeInsert [l]
  (fn [a]
    (fn [rec]
      (assoc rec l a))))

(defn unsafeModify [l]
  (fn [f]
    (fn [rec]
      (update rec l f))))

(defn unsafeDelete [l]
  (fn [rec]
    (dissoc rec l)))

(defn unsafeRename [l1]
  (fn [l2]
    (fn [rec]
      (rename-keys rec {l1 l2}))))
