# elixir-service serverless API
The elixir-service project, created with [`aws-serverless-java-container`](https://github.com/awslabs/aws-serverless-java-container).

The starter project defines a simple `/survey` resource that can accept `GET` requests with its tests.

The project folder also includes a `template.yml` file. You can use this [SAM](https://github.com/awslabs/serverless-application-model) file to deploy the project to AWS Lambda and Amazon API Gateway or test in local with the [SAM CLI](https://github.com/awslabs/aws-sam-cli). 

## Pre-requisites
* [AWS CLI](https://aws.amazon.com/cli/)
* [SAM CLI](https://github.com/awslabs/aws-sam-cli)
* [Gradle](https://gradle.org/) or [Maven](https://maven.apache.org/)

## Building the project
You can use the SAM CLI to quickly build the project

```bash
$ mvn archetype:generate -DgroupId=au.com.totemsoft.serverless.elixir -DartifactId=elixir-service -Dversion=1.0.0-SNAPSHOT \
  -DarchetypeGroupId=com.amazonaws.serverless.archetypes \
  -DarchetypeArtifactId=aws-serverless-jersey-archetype \
  -DarchetypeVersion=1.5 -Dinteractive=false

$ mvn archetype:generate -DgroupId=au.com.totemsoft.serverless.elixir -DartifactId=elixir-service -Dversion=1.0.0-SNAPSHOT \
  -DarchetypeGroupId=com.amazonaws.serverless.archetypes \
  -DarchetypeArtifactId=aws-serverless-springboot-archetype \
  -DarchetypeVersion=1.5 -Dinteractive=false

$ cd elixir-service
$ sam build

    Building resource 'ElixirServiceFunction'
    Running JavaGradleWorkflow:GradleBuild
    Running JavaGradleWorkflow:CopyArtifacts
    Build Succeeded

Built Artifacts  : .aws-sam/build
Built Template   : .aws-sam/build/template.yaml

Commands you can use next
=========================
[*] Invoke Function: sam local invoke
[*] Deploy: sam deploy --guided
```

## Testing locally with the SAM CLI

From the project root folder - where the `template.yml` file is located - start the API with the SAM CLI.

```bash
$ sam local start-api

...
Mounting com.amazonaws.serverless.archetypes.StreamLambdaHandler::handleRequest (java8) at http://127.0.0.1:3000/{proxy+} [OPTIONS GET HEAD POST PUT DELETE PATCH]
...
```

Using a new shell, you can send a test survey request to your API:

```bash
$ curl -s http://127.0.0.1:3000/survey | python -m json.tool
{
    "survey": "Survey"
}
``` 

## Deploying to AWS
To deploy the application in your AWS account, you can use the SAM CLI's guided deployment process and follow the instructions on the screen

```
$ sam deploy --guided
```

Once the deployment is completed, the SAM CLI will print out the stack's outputs, including the new application URL. You can use `curl` or a web browser to make a call to the URL

```
...
-------------------------------------------------------------------------------------------------------------
OutputKey-Description                        OutputValue
-------------------------------------------------------------------------------------------------------------
ElixirServiceApi - URL for application       https://xxxxxxxxxx.execute-api.ap-southeast-2.amazonaws.com/Prod/{proxy+}
-------------------------------------------------------------------------------------------------------------
```

Asynchronous invocation

```
aws lambda invoke --function-name elixir-service-ElixirServiceFunction-17O69M1FYNDJI --invocation-type Event\
  --payload '{ "path": "/health" }'\
  response.json

aws lambda invoke  --function-name findClients outfile=findClients.txt
```

Copy the `OutputValue` into a browser or use curl to test your first request:

```bash
$ curl -s https://xxxxxxxxxx.execute-api.ap-southeast-2.amazonaws.com/Prod/survey/1963 | python -m json.tool
{
    "survey": "Survey"
}
```

## AWS Cognito
https://docs.aws.amazon.com/cognito/latest/developerguide/token-endpoint.html
Access token url: https://elixir.auth.ap-southeast-2.amazoncognito.com/oauth2/token
