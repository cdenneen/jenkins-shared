#!/usr/bin/groovy

def call(Closure body) {
    podTemplate(label: 'puppet', containers:[
        containerTemplate(name: 'ruby21', image: 'ruby:2.1-alpine', ttyEnabled: true, command: 'cat'),
        containerTemplate(name: 'ruby22', image: 'ruby:2.2-alpine', ttyEnabled: true, command: 'cat'),
        containerTemplate(name: 'ruby23', image: 'ruby:2.3-alpine', ttyEnabled: true, command: 'cat')
    ]){
        node('puppet') {
                container('ruby21'){
                    body()
                }
                container('ruby22'){
                    body()
                }
                container('ruby23'){
                    body()
                }
        }
    }
}
