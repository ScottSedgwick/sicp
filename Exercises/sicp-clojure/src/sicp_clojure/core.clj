(ns sicp-clojure.core
  (:gen-class)
  (:import org.pushingpixels.substance.api.SubstanceLookAndFeel)
  (:require [seesaw.core :refer :all]))

(def ms_per_day (* 24 3600 1000))
(defn date_for_day [d] (java.util.Date. (long (* d ms_per_day))))

(def lbl1 "A default spinner (print value change to stdout)")
(def spn1 (spinner :listen [:selection (fn [e] (println (selection e)))]))

(def lbl2 "A spinner over a sequence of values")
(def spn2 (spinner :model (map #(str "Value" %) (range 0 100 5))))

(def lbl3 "An unbounded spinner starting at a particular date")
(def spn3 (spinner :model (java.util.Date. (long 12345678900))))

(def lbl4 "A numeric spinner starting at a particular value")
(def spn4 (spinner :model 3.14159))

(def lbl5 "A numeric spinner (spinner-model 3.5 :from 1.5 :to 4.5 :by 0.5)")
(def spn5 (spinner :model (spinner-model 3.5 :from 1.5 :to 4.5 :by 0.5)))

(def lbl6 "A date spinner with explicit start and end")
(def spn6 (spinner :model (let [s (date_for_day 1000)
                                v (date_for_day 2000)
                                e (date_for_day 3000)]
                           (spinner-model v :from s :to e :by :day-of-month))))


(defn laf-selector []
  (horizontal-panel
    :items ["Substance skin: "
            (combobox
              :model    (vals (SubstanceLookAndFeel/getAllSkins))
              :renderer (fn [this {:keys [value]}]
                          (text! this (.getClassName value)))
              :listen   [:selection (fn [e]
                                      ; Invoke later because CB doens't like changing L&F while
                                      ; it's doing stuff.
                                      (invoke-later
                                        (-> e
                                          selection
                                          .getClassName
                                          SubstanceLookAndFeel/setSkin)))])]))

(defn -main [& args]
  (seesaw.core/native!)
  (invoke-later
    (-> (frame :title "Spinner Example",
               :on-close :exit,
               :content (vertical-panel :items [
                           (laf-selector)
                           (grid-panel :columns 2
                                       :hgap 5
                                       :vgap 2
                                       :items [lbl1 spn1
                                               lbl2 spn2
                                               lbl3 spn3
                                               lbl4 spn4
                                               lbl5 spn5
                                               lbl6 spn6])])
        ) pack! show!)))

