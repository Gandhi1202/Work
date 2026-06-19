FROM node:22-alpine AS firststage
WORKDIR /react
COPY package*.json ./
RUN npm install 
COPY . .

RUN npm run build
FROM nginx:alpine AS secondstage

COPY --from=firststage /react/build /usr/share/nginx/html


EXPOSE 80


CMD ["nginx","-g","daemon off;"]





