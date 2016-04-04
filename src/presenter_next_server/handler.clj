;; Simple counter service

;; This server-side app will maintain a counter value which can also be reset.

;; Author: @jr0cket
;; Licence: MIT
;; Copyright 

(ns presenter-next-server.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def counter (atom 0))

(defn next-please [request]
  {:status 200
   :header []
   :body "Oy, change the slide..."})

(defn counter-increment [request]
  (swap! counter inc)
  {:status 200
   :header []
   :body (str @counter)})

(defn counter-reset [request]
  (reset! counter 0)
  {:status 200
   :header []
   :body (str @counter)})

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/next-please" [] next-please)
  (GET "/counter-increment" [] counter-increment)
  (GET "/counter-reset" [] counter-reset)
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)))


;;@counter
;;deref counter

;; count the number of IPs and calculate the audience size

