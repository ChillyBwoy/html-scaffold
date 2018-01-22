(ns leiningen.new.html-scaffold
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "html-scaffold"))

(defn html-scaffold
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data
      [".gitignore"                                   (render ".gitignore" data)]
      ["gulpfile.js"                                  (render "gulpfile.js" data)]
      ["package.json"                                 (render "package.json" data)]
      ["project.clj"                                  (render "project.clj" data)]
      ["resources/public/js/main.js"                  (render "resources/public/js/main.js" data)]
      ["resources/public/html/.gitkeep"               (render "resources/public/html/.gitkeep" data)]
      ["src/clj/{{sanitized}}/components/common.clj"  (render "src/clj/new/components/common.clj" data)]
      ["src/clj/{{sanitized}}/utils/dom.clj"          (render "src/clj/new/utils/dom.clj" data)]
      ["src/clj/{{sanitized}}/views/index.clj"        (render "src/clj/new/views/index.clj" data)]
      ["src/clj/{{sanitized}}/views/main.clj"         (render "src/clj/new/views/main.clj" data)]
      ["src/clj/{{sanitized}}/views/not_found.clj"    (render "src/clj/new/views/not_found.clj" data)]
      ["src/clj/{{sanitized}}/core.clj"               (render "src/clj/new/core.clj" data)]
      ["src/clj/{{sanitized}}/handler.clj"            (render "src/clj/new/handler.clj" data)]
      ["src/clj/{{sanitized}}/layout.clj"             (render "src/clj/new/layout.clj" data)]
      ["src/clj/{{sanitized}}/render.clj"             (render "src/clj/new/render.clj" data)]
      ["src/cljs/{{sanitized}}/core.cljs"             (render "src/cljs/new/core.cljs" data)]
      ["src/cljs/{{sanitized}}/repl.cljs"             (render "src/cljs/new/repl.cljs" data)]
      ["src/css/{{sanitized}}/views/index.css"        (render "src/css/new/views/index.css" data)]
      ["src/css/{{sanitized}}/views/main.css"         (render "src/css/new/views/main.css" data)]
      ["src/css/{{sanitized}}/views/vendor.css"             (render "src/css/new/views/vendor.css" data)]
      ["src/css/{{sanitized}}/base.css"               (render "src/css/new/base.css" data)]
      ["src/css/{{sanitized}}/media.css"              (render "src/css/new/media.css" data)]
      ["src/css/{{sanitized}}/mixins.css"             (render "src/css/new/mixins.css" data)]
      ["src/css/{{sanitized}}/page.css"               (render "src/css/new/page.css" data)]
      ["src/css/{{sanitized}}/vars.css"               (render "src/css/new/vars.css" data)])))
