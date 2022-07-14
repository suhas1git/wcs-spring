Skip to content
Search or jump to…
Pull requests
Issues
Marketplace
Explore
 
@suhas1git 
suhas1git
/
wcs-spring
Public
Code
Issues
Pull requests
Actions
Projects
Wiki
Security
Insights
Settings
wcs-spring/Jenkinsfile
@suhas1git
suhas1git Update Jenkinsfile
Latest commit 6cf0971 1 hour ago
 History
 1 contributor
59 lines (50 sloc)  1.88 KB

node("master") {
        // This is a demo
    def buildNumberId = getBuildNumber()
    try {
            
            stage("Checking out SCM") {
        // try{
            checkout scm
             echo "*** ${buildNumberId} ***"
             to fail       
               
        // }
        
    }
    }
   catch (e) {
           currentBuild.result = "FAILED"
           throw e
           //error( 'Exception occurred dureing Checkout: ' + e.toString() )
           //sh 'Handle the exception!'
        }


    try{
            if(!isDeployableBranch()){
            stage("Test Condition"){
                echo "******************************"
                    hi
            }
         }
      
    }
    catch(Exception e) {
         //echo 'Exception occurred dureing Deploy: ' + e.toString()
          error("Build failed because of :: " + e.toString())
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


def notifySuccessful() {
 
  emailext (
      subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      body: """<p>SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
      recipientProviders: [[$class: 'DevelopersRecipientProvider']]
    )
}
