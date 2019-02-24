import json
import selectHotelByAiportID


def lambda_handler(event, context):
    results_tuple = selectHotelByAiportID.handler(event["id"])
    return {
        "statusCode": 200,
        "keys": json.dumps(results_tuple[0]),
        "results": json.dumps(results_tuple[1])
    }


#print(lambda_handler({'id': '6'},{}))
