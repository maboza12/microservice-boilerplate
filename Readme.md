# Microservice Boilerplate Starter Pack

## Bundle the OpenAPI Spec
```aidl
gradle bundleOpenApiYaml
```
Built OpenAPI spec can be found parsed together at the _build folder under ./openapi/server/_build
## Linting OpenAPI Spec
```aidl
gradle lintOpenApi
```

## Mock Data for API
```aidl
gradle mockOpenApiData
```

## Preview APIs
```aidl
gradle previewApi
```

## Validate Mock Results with Actual Results
Checks that the results generated from the spec mocker match up with the application code

- The code must be generated and built to validate this


