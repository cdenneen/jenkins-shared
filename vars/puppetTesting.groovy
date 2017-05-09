#!/usr/bin/groovy

def call(String[] puppetVersions = ['4.7.1', '4.8.1', '4.9.4'], Closure body) {
  def puppetMatrix = [:]
  for (int i = 0; i < puppetVersions.size(); i++) {
    def index = i
//    puppetMatrix["${puppetVersions[index]}"] = {
      stage("${puppetVersions[index]}"){
        withEnv(["PUPPET_GEM_VERSION=${puppetVersions[index]}","STRICT_VARIABLES=no"]){
          puppetPrep
          puppetLint
          puppetUnit
        }
      }
//    }
  }
//  parallel puppetMatrix
}
