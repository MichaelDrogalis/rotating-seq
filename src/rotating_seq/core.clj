(ns rotating-seq.core)

(defn create-r-seq [bucket-lifetime expire-interval]
  (assert (zero? (mod bucket-lifetime expire-interval)) "Bucket lifetime must divide evenly over expiration interval")
  (let [n-buckets (int (Math/ceil (/ bucket-lifetime expire-interval)))]
    (vec (repeat n-buckets []))))

(defn add-to-head [r-seq elements]
  (update-in r-seq [0] into elements))

(defn expire-bucket [r-seq]
  (conj (pop r-seq) []))
