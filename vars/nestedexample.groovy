#!/usr/bin/groovy

def call(Closure body) {
  sh "echo strict is ${env.STRICT_VARIABLES}"
  sh "echo puppet is ${env.PUPPET_GEM_VERSION}"
}
