APP_NAME="devsu-test"

docker build -t $APP_NAME .
docker run -p 8080:8080 $APP_NAME
