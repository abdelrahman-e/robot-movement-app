const nextConfig = {
    async headers() {
        return [
            {
                // matching all API routes
                source: "/api/:path*",
                headers: [
                    {key: "Access-Control-Allow-Credentials", value: "true"},
                    {key: "Access-Control-Allow-Origin", value: "http://localhost:3000"},
                    {key: "Access-Control-Allow-Methods", value: "GET,DELETE,PATCH,POST,PUT,OPTION"},
                    {
                        key: "Access-Control-Allow-Headers",
                        value: "X-CSRF-Token, X-Requested-With, Accept, Accept-Version, Content-Length, Content-MD5, Content-Type, Date, X-Api-Version"
                    },
                ]
            }
        ]
    }
}

module.exports = nextConfig