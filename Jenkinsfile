node("master") {
        // This is a demo
    def buildNumberId = getBuildNumber()
    try {
            
            stage("Checking out SCM") {
        // try{
            checkout scm
             echo "*** ${buildNumberId} ***"
        // }
        
    }
    }
   catch (Exception e) {
             echo 'Exception occurred dureing Checkout: ' + e.toString()
             sh 'Handle the exception!'
        }
    try{
            if(isDeployableBranch()){
        stage("Test Condition"){
                echo "******************************"
                hi
        }
    }
      
    }
    catch(Exception e) {
         echo 'Exception occurred dureing Checkout: ' + e.toString()
    }
  


}

def getBuildNumber(buildCounter=1) {
def commitId = sh(script: "git rev-parse HEAD", returnStdout: true).trim()
def shortCommitId = sh script: "git rev-parse --short ${commitId}", returnStdout: true
shortCommitId = shortCommitId.trim()
if(buildCounter) {
    //The buildNumber will be of the form V-123deaf4-43
    def buildNumber = (env.BUILD_NUMBER.toInteger() + buildCounter)
    def buildNumberWithShortCommitId = "V"+"-"+shortCommitId+"-"+buildNumber
    buildNumberWithShortCommitId = buildNumberWithShortCommitId.replaceAll(~/\./,"-")
    print("Build number = [${buildNumberWithShortCommitId}]")
    return buildNumberWithShortCommitId
} else {
        def buildNumberWithShortCommitId = sh(script: "git describe --long --tags --always ${commitId}", returnStdout: true).trim()
        buildNumberWithShortCommitId = buildNumberWithShortCommitId.replaceAll(~/\./,"-")
        print("Build number = [${buildNumberWithShortCommitId}]")
        return buildNumberWithShortCommitId
    }
}

def isDeployableBranch(){
    return (env.BRANCH_NAME == 'develop' || env.BRANCH_NAME == 'master')
}
