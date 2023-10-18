APP_ACCOUNT_NAME="devsu-account"
APP_CLIENT_NAME="devsu-client"
cd ./account
./gradlew build
cd ../client
./gradlew build
cd ..
docker build -t $APP_ACCOUNT_NAME ./account
docker build -t $APP_CLIENT_NAME ./client

docker-compose up
