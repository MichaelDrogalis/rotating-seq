(ns rotating-seq.core)

(defn create-r-seq [bucket-lifetime expire-interval]
  (let [n-buckets (int (Math/ceil (/ bucket-lifetime expire-interval)))]
    (vec (repeat n-buckets []))))

(defn add-to-head [r-seq elements]
  (update-in r-seq [0] (comp vec concat) elements))

(defn expire-bucket [r-seq]
  (vec (conj (butlast r-seq) [])))
