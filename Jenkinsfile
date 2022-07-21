pipeline {
    agebt any
    stages{
        stage("Checkout"){
            steps{
                checkout scm
            }
            githubPRAddLabels labelProperty: labels('Checkout')
        }
        stage("Test")
        {
            steps{
                echo "Test"
            }
        }
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
