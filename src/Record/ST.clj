(ns Record.ST._foreign
  (:import [java.util Map HashMap]))

(defn freeze [^Map rec]
  (fn [& _]
    (into {} rec)))

(defn thaw [^Map rec]
  (fn [& _]
    (HashMap. rec)))

(defn unsafePeek [l]
  (fn [^Map rec]
    (fn [& _]
      (.get rec l))))

(defn unsafePoke [l]
  (fn [a]
    (fn [^Map rec]
      (fn [& _]
        (.put rec l a)))))

(defn unsafeModify [l]
  (fn [f]
    (fn [^Map rec]
      (fn [& _]
        (.put rec l (f (.get rec l)))))))
