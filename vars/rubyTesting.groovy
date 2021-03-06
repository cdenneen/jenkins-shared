#!/usr/bin/groovy

def call(String[] rubyVersions = ['ruby21', 'ruby22', 'ruby23'], Closure body) {
  podTemplate(label: 'rubypod', containers:[
    containerTemplate(name: 'ruby21', image: 'ruby:2.1', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'ruby22', image: 'ruby:2.2', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'ruby23', image: 'ruby:2.3', ttyEnabled: true, command: 'cat')
  ]){
    node('rubypod') {
      def rubyMatrix = [:]
      for (int i = 0; i < rubyVersions.size(); i++) {
        def index = i
//        rubyMatrix["${rubyVersions[index]}"] = {
          stage("${rubyVersions[index]}"){
            container(name: "${rubyVersions[index]}"){
              body()
            }
          }
//        }
      }
//      parallel rubyMatrix
    }
  }
}
