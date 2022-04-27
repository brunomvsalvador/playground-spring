# Playground-Spring

**Java version**: 11

**Build**:
    mvn clean install

**Start**:
    java -jar target/spring-0.0.1-SNAPSHOT.ja

----
## Insurance Premium

### Requests
* POST `http://localhost:8080/premium/calculate`
```
{
  "number": "LV20-02-100000-5",
  "status": "APPROVED",
  "objects": [
    {
      "name": "item1",
      "subObjects": [
        {
          "name": "item1::sub-item1",
          "riskType": "FIRE",
          "insured": 100.0
        },
        {
          "name": "item1::sub-item2",
          "riskType": "THEFT",
          "insured": 8.0
        }
      ]
    }
  ]
}
```
```
{
  "number": "LV20-02-100000-5",
  "status": "APPROVED",
  "objects": [
    {
      "name": "item1",
      "subObjects": [
        {
          "name": "item1::sub-item1",
          "riskType": "FIRE",
          "insured": 500.0
        },
        {
          "name": "item1::sub-item2",
          "riskType": "THEFT",
          "insured": 102.51
        }
      ]
    }
  ]
}
```
