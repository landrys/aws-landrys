# TODO
  
  * Clean out the EFS system.

# aws-landrys
Due Date Using Amazon Web Services

## Summary
These modules contain code supporting the Due Date service. In order to deploy the code we are using the AWS cli interface. 
The procedure to do this goes as follows:

Get the code
  * git clone https://github.com/landrys/aws-landrys.git

Package it up ( Need to have AWS credentials set up in yout home directory .aws folder credentials file. See AWS docs for more info )
  * From top level direcctory -> `mvn clean package`

If the function is already created in AWS, update with following CLI command.
  * `aws lambda update-function-code  --profile lambdaAdmin    --function-name dueDate   --zip-file fileb://aws-due-date/target/aws-due-date-1.0.0.jar`

If the function is not created in AWS, create with following CLI command.
  * `aws lambda create-function  --profile lambdaAdmin    --function-name dueDate      --runtime java8      --zip-file fileb://aws-due-date/target/aws-due-date-1.0.0.jar      --handler com.landry.aws.lambda.duedate.LambdaFunctionHandler      --role arn:aws:iam::419745589400:role/lambda_basic_execution`

(*The role is defined in AWS's IAM Service*)

The function is now updated or created and the code is deployed to the '$LATEST' Version of the Lambda function. At this point we can create a version snapshot from this latest version via the AWS web interface or the CLI. Before we do that let's see what versions exist now.

* aws lambda list-versions-by-function  --profile lambdaAdmin    --function-name dueDate

Create the new version:
* `aws lambda publish-version  --profile lambdaAdmin    --function-name dueDate --description "My New Version"`

The Version can be viewed from response or by  listing the versions again
* `aws lambda list-versions-by-function  --profile lambdaAdmin    --function-name dueDateAWSCLI`

At this point we create an alias or use the alias we have. We can list aliases in our function byt CLI command:
* `aws lambda list-aliases  --profile lambdaAdmin    --function-name dueDate`

Our Eleven Web client uses this alias to call the due date service. Once you want to go live attach this alias to any version you want. To do this use the CLI command:
* `aws lambda update-alias  --profile lambdaAdmin    --function-name dueDate -name PROD --function-version <versionNumber>`

## Testing via CLI

* aws lambda invoke --profile lambdaAdmin --function-name dueDate --qualifier PROD --payload '{"store": "Natick","vendorShipTimeIds": [1]}' response.json

## Testing via MVN 

* From parent directory -->  `mvn test -Dtest=LambdaFunctionHandlerTest#testMe -pl aws-dynamo`

## Notes from previous
TODO: get the dueDataAWSClI workignusing S3 storage so that it is like the one we have. Do we need to do this...?
      If you do not specify and S3 in the aws cli create-function it goes to a place you cannot manage or see. See docs in AWS.

After you make changes to dependent projects and do an install do the following
mvn  -Dmaven.test.skip=true package
mvn  -DskipTests=true package

aws lambda create-function  --profile lambdaAdmin    --function-name dueDateAWSCLI      --runtime java11      --zip-file fileb://aws-due-date-4.0.0.jar      --handler com.landry.aws.lambda.duedate.LambdaFunctionHandler      --role arn:aws:iam::419745589400:role/lambda_basic_execution

aws lambda update-function-code  --profile lambdaAdmin    --function-name dueDateAWSCLI   --zip-file fileb://aws-due-date-4.0.0.jar

aws lambda invoke --profile lambdaAdmin --function-name dueDateAWSCLI --payload '{"store": "Natick","vendorShipTimeIds": [1]}' response.json

aws lambda publish-version  --profile lambdaAdmin    --function-name dueDateAWSCLI --description "First try"
aws lambda create-alias  --profile lambdaAdmin  --function-version 1  --function-name dueDateAWSCLI --name myAlias --description myAliasToTryDesc

python -m json.tool response.json

