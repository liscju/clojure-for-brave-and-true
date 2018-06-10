(ns clojure-for-brave-and-true.chapter7.exercise2)

(def infix-expr '(1 + 3 * 4 - 5))

(def operators ['- '+ '*])

(defn infix-to-prefix
  [infix-expr]
  (if (empty? infix-expr)
    infix-expr
    (if (= (count infix-expr) 1)
      (nth infix-expr 0)
      (let [highest-prec-op
            (nth operators
              (apply max
                (map #(.indexOf operators %)
                   (filter #(some (fn [x] (= x %)) operators) infix-expr))))
            highest-prec-op-idx
              (first
                (keep-indexed
                  #(when (= highest-prec-op %2) %1) infix-expr))
            left-arg-idx (dec highest-prec-op-idx)
            left-arg  (nth infix-expr left-arg-idx)
            right-arg-idx (inc highest-prec-op-idx)
            right-arg (nth infix-expr right-arg-idx)
            rest-left (take left-arg-idx infix-expr)
            rest-right (drop (inc right-arg-idx) infix-expr)]
        (infix-to-prefix
          (concat rest-left
            (cons
              (list highest-prec-op left-arg right-arg)
              rest-right)))))))