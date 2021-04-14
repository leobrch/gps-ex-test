
## How to run this application
At the command prompt, type `mvn spring-boot:run` it will run on `default` profile with port `9999`

Here are some workflows for the APIs:

- Get list of latest tracks - GET : http://localhost:9999/gps/latest/track

![Get list of latest tracks](./workflow/gps_list_data_workflow.png)

- Get detail of GPS detail - GET : http://localhost:9999/gps/detail/{id}

![Get detail of GPS detail](./workflow/gps_track_detail_workflow.png)

- Upload a gpx file - POST : http://localhost:9999/gps/upload

![Upload a gpx file](./workflow/upload_file_workflow.png)