(ns clojure-for-brave-and-true.chapter5.exercise5)

(defn update-in
  ([m [k & ks] f & args]
   (if ks
     (assoc m k (apply update-in (get m k) ks f args))
     (assoc m k (apply f (get m k) args)))))