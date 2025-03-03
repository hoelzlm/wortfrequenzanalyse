FROM node:22

RUN mkdir /wfa-frontend
WORKDIR  /wfa-frontend

RUN npm install -g @angular/cli

COPY package.json package-lock.json ./
RUN npm install

COPY . .
CMD ["ng", "serve", "--configuration", "docker",  "--host", "0.0.0.0"]